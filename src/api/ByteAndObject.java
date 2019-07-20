package api;


import java.io.*;

public class ByteAndObject {
    public static void main(String[] args) {
        Img img = new Img();
        String cont = "6  d  I LOVE SunMeiQin!!!!!";
        img.imgBytes = cont.getBytes();
        img.length = cont.length();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"));
            objectOutputStream.writeInt(img.length);
            objectOutputStream.write(img.imgBytes);
            objectOutputStream.writeInt("afsafa".length());
            objectOutputStream.write("afs@@@afa".getBytes());
            objectOutputStream.flush();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"));
            int count = objectInputStream.readInt();
            byte[]contBt=new byte[count];

            objectInputStream.read(contBt);
            byte[]contBt1=new byte[objectInputStream.readInt()];
            objectInputStream.read(contBt1);
            objectInputStream.close();
            System.out.println(new String(contBt));
            System.out.println(new String(contBt1));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static class Img implements Serializable{

        int length;
        byte[] imgBytes;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public byte[] getImg() {
            return imgBytes;
        }

        public void setImg(byte[] img) {
            this.imgBytes = img;
        }
    }
}
