package arc.jumanpp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Juman {
    
    private Process jumanProcess = null;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public Juman() throws IOException {
        this("~/Jumanpp/bin/jumanpp");
    }

    public Juman(String path) throws IOException {
        ProcessBuilder processBuidler = new ProcessBuilder("/bin/bash", "-c", path);
        this.jumanProcess = processBuidler.start();
        this.reader = new BufferedReader(new InputStreamReader(jumanProcess.getInputStream()));
        this.writer = new BufferedWriter(new OutputStreamWriter(jumanProcess.getOutputStream()));
    }

    public String parseString(String text) throws IOException {
        if(!jumanProcess.isAlive())
            throw new IOException();
        writer.write(text + "\r\n");
        writer.flush();

        String result = "";
        while(true) {
            String line = reader.readLine();
            if (line == null || "EOS".equalsIgnoreCase(line)) break;
            result += line; 
        }
        
        return result;
    }
}