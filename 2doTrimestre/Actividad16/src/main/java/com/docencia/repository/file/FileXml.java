package com.docencia.repository.file;

public class FileXml extends FileAbstract{
    private static String path = "alumnos.xml";

    public FileXml(){
        super(path);
    }

    public FileXml(String path) {
        super(path);
    }
    
}
