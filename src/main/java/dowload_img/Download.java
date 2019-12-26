package dowload_img;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Download {

    private String link;
    private File out;
    private String direct;

    public Download(String link, File out, String direct) {
        this.link = link;
        this.out = out;
        this.direct = direct;
    }

    public void createFolder(String direct){
        try {
            File file = new File(direct);
            file.mkdir();

            if (file.createNewFile()){
                System.out.println("New File is created!");
            }else{
                System.out.println("File with the same name already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadFile(){
        try {
            createFolder(direct);
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            double fileSize = conn.getContentLengthLong();
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            FileOutputStream fos = new FileOutputStream(out);
            BufferedOutputStream bos = new BufferedOutputStream(fos,1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read;
            double percentDownloaded = 0.00;
            while ((read = bis.read(buffer,0, 1024)) >= 0){
                bos.write(buffer, 0, 1024);
                downloaded += read;
                percentDownloaded = downloaded*100/fileSize;
                String percent = String.format("%.4f",percentDownloaded);
                System.out.println(percent+"%");
            }
            bis.close();
            bos.close();
            System.out.println("complete");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void downloadImg(String link) {
        try {
            URL url = new URL(link);

            URLConnection conn = url.openConnection();

            InputStream in = conn.getInputStream();
            byte[] b = new byte[1024];
            FileOutputStream out = new FileOutputStream("/Users/kislupin/Desktop/crawl/src/main/file"+"/"+"test.jpg");
            int le = in.read(b);
            while (le != -1){
                out.write(b, 0, le);
                le = in.read(b);
            }
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
