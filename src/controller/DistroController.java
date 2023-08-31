package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
    public DistroController() {
        super();
    }

    private String VerifyOS() {
        return System.getProperty("os.name");
    }

    public String exibeDistro() {
        String OS = VerifyOS();
        if (OS.contains("Windows")) {
            String ver = System.getProperty("os.version");
            return "Sistema Windows detectado: Versão "+ver;
        } else {//Linux
            StringBuilder LinuxDistro = new StringBuilder();
            LinuxDistro.append("Linux detectado:\n");
            try {
                Process Distro = Runtime.getRuntime().exec("cat /etc/os-release");
                InputStream fluxo = Distro.getInputStream();
                InputStreamReader reader = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(reader);

                String linha = buffer.readLine();
                while (linha != null) {
                    if (linha.contains("NAME")) {
                        LinuxDistro.append(linha).append("\n");
                    }
                    if (linha.contains("VERSION")) {
                        LinuxDistro.append(linha).append("\n");
                    }
                    linha = buffer.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return LinuxDistro.toString();
        }
    }
}
