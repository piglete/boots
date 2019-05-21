package com.bych.file.manager;

import com.bych.file.model.FileInfo;
import com.bych.file.model.Plupload;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojinxiong
 * Date: 2018-12-07
 * Time: 11:37
 * Description:
 */
public interface PluploadManager {

    FileInfo upload(Plupload plupload, File dir);

    Integer remove(String path);

    boolean downFile(String name, String filePath, HttpServletResponse response);
}
