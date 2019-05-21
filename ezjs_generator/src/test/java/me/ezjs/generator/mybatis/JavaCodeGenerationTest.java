/**
 * Copyright 2006-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.ezjs.generator.mybatis;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

import me.ezjs.generator.mybatis.api.GeneratedJavaFile;
import me.ezjs.generator.mybatis.api.MyBatisGenerator;
import me.ezjs.generator.mybatis.config.Configuration;
import me.ezjs.generator.mybatis.internal.DefaultShellCallback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import me.ezjs.generator.mybatis.config.xml.ConfigurationParser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;

@RunWith(Parameterized.class)
public class JavaCodeGenerationTest {

    private GeneratedJavaFile generatedJavaFile;

    public JavaCodeGenerationTest(GeneratedJavaFile generatedJavaFile) {
        this.generatedJavaFile = generatedJavaFile;
    }

    @Test
    public void testJavaParse() {
        ByteArrayInputStream is = new ByteArrayInputStream(
                generatedJavaFile.getCompilationUnit().getFormattedContent().getBytes());
        try {
            JavaParser.parse(is);
        } catch (ParseException e) {
            fail("Generated Java File " + generatedJavaFile.getFileName() + " will not compile");
        }
    }

    @Parameters
    public static List<GeneratedJavaFile> generateJavaFiles() throws Exception {
        List<GeneratedJavaFile> generatedFiles = new ArrayList<GeneratedJavaFile>();
        generatedFiles.addAll(generateJavaFilesMybatis());
        generatedFiles.addAll(generateJavaFilesIbatis());
        return generatedFiles;
    }

    private static List<GeneratedJavaFile> generateJavaFilesMybatis() throws Exception {
        createDatabase();
        return generateJavaFiles("/generatorConfig.xml");
    }

    private static List<GeneratedJavaFile> generateJavaFilesIbatis() throws Exception {
        createDatabase();
        return generateJavaFiles("/scripts/ibatorConfig.xml");
    }

    private static List<GeneratedJavaFile> generateJavaFiles(String configFile) throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(JavaCodeGenerationTest.class.getResourceAsStream(configFile));

        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
        myBatisGenerator.generate(null, null, null, false);
        return myBatisGenerator.getGeneratedJavaFiles();
    }

    public static void createDatabase() throws Exception {
        SqlScriptRunner scriptRunner = new SqlScriptRunner(JavaCodeGenerationTest.class.getResourceAsStream("/scripts/CreateDB.sql"), "org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:aname", "sa", "");
        scriptRunner.executeScript();
    }
}
