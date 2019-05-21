package club.map.base.util;

import com.wanqing.util.FtpHandler;
import com.wanqing.util.StringHandler;
import com.wanqing.util.UUID;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojinxiong
 * Date: 2018-12-01
 * Time: 11:09
 * Description:
 */
public class FtpUtils {

    //ftp服务器配置
//    public static String hostname = "10.0.0.200";
//    public static String username = "admin";
//    public static String password = "admin";
//    public static final String real_FILE_DIR = "C:/ftpServer/upload";

    //ftp服务器端口号默认为21
    public static Integer port = 21;

    //ftp本机配置
    public static String hostname = "192.168.50.32";
    public static String username = "zjx";
    public static String password = "zjx";
    public static final String REAL_FILE_DIR = "E:/ftpServer/upload";

    //操作文件存放目录
    public static String URL_PATH = "upload";

    //操作规范存放路径
    public static String STR_PATH = "handbook";

    //客户资料存放
    public static String CUSTOMER_DOCUMENT_PATH = "customer";

    //任务文件
    public static String TASK = "task";

    //档案文件
    public static String RECORD = "record";

    public static FTPClient ftpClient = null;

    /**
     * 文件上传(单个)
     *
     * @param file 文件
     * @param path 文件目录
     */
    public static int uploadFtpFile(MultipartFile file, String path, String fileRename) throws Exception {
        InputStream is = file.getInputStream();
        FtpHandler ftpHandler = new FtpHandler(hostname, port, username, password);
//        boolean flag = FtpUtils.CreateDirecroty(path);
        try {
            ftpHandler.uploadFile(is, path, fileRename);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            if ("500".equals(msg)) {
                return -1;
            } else {
                throw e;
            }
        }
    }

    private static void CreateDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
     */
    public static boolean CreateDirecroty(String remote) throws IOException {
        boolean success = true;
        String directory = remote + "/";
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                if (!existFile(path)) {
                    if (makeDirectory(subDirectory)) {
                        changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(subDirectory);
                    }
                } else {
                    changeWorkingDirectory(subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    //改变目录路径
    public static boolean changeWorkingDirectory(String directory) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                System.out.println("进入文件夹" + directory + " 成功！");

            } else {
                System.out.println("进入文件夹" + directory + " 失败！开始创建文件夹");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }

    //判断ftp服务器文件是否存在
    public static boolean existFile(String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }

    //创建目录
    public static boolean makeDirectory(String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("创建文件夹" + dir + " 成功！");

            } else {
                System.out.println("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 文件重命名
     *
     * @param sourceFile
     * @return
     */
    public static String fileReName(String sourceFile) {
        String distFileName = "";
        if (!StringHandler.isEmptyOrNull(sourceFile)) {
            String ext = fileExetName(sourceFile);
            distFileName = UUID.uuId() + "." + ext;
        }

        return distFileName;
    }

    /**
     * 文件重命名
     *
     * @param sourceFileName
     * @return
     */
    public static String fileExetName(String sourceFileName) {
        String ext = "";
        if (!StringHandler.isEmptyOrNull(sourceFileName)) {
            int index = sourceFileName.lastIndexOf(".");
            ext = sourceFileName.substring(index + 1);
        }

        return ext;
    }

    /**
     * 文件下载
     *
     * @param response
     * @param path       文件目录
     * @param fileName   原文件名称
     * @param fileRename 服务器保存的文件名称
     */
    public boolean downloadByFtp(HttpServletResponse response, String path, String fileName, String fileRename) throws Exception {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        InputStream in = null;
        boolean flag = false;
        try {
            in = downloadFtpFile(hostname, port, username, password, path, fileRename);
            long fileLength = 0;
            String fileNameTemp = new String(fileName.getBytes("GBK"),
                    "ISO8859-1");
            bis = new BufferedInputStream(in);
            //清空response
            response.reset();
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment; filename=\""
                    + fileNameTemp + "\"");
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = bis.read(buffer)) != -1) {
                fileLength += len;
                bos.write(buffer, 0, len);
            }
            response.addHeader("Content-Length", "" + fileLength);
            bos.flush();
            flag = true;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
                if (null != bis) {
                    bis.close();
                }
                if (null != bos) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 文件下载
     */
    public static InputStream downloadFtpFile(String server, int port, String username, String password, String remoteFold, String fileName) throws Exception {
        FtpHandler ftpHandler = new FtpHandler(server, port, username, password);
        return ftpHandler.downloadFile(remoteFold, fileName);
    }

    /**
     * 删除ftp文件
     */
    public static boolean deleteFtpFile(String filePath, String fileName) {
        FtpHandler ftpHandler = new FtpHandler(hostname, port, username, password);
        return ftpHandler.deleteFtpServerFile(filePath, fileName);
    }

    /**
     * 文件夹下载
     *
     * @param response
     * @param remoteDirectory
     * @param localDirectoryPath
     * @return
     */
    public static List<FTPFile> downloadFolderByFtp(HttpServletResponse response, String remoteDirectory) {
        FtpHandler ftpHandler = new FtpHandler(hostname, port, username, password);
        List<FTPFile> files = null;
        try {
            files = ftpHandler.getFileList(remoteDirectory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }
}
