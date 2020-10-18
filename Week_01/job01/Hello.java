/**
 * @author isaac
 * @date 2020/10/17
 */
public class Hello {
    public static void main(String[] args) {
        byte helloByte = 1;
        helloByte = (byte) (helloByte + 1);
        helloByte = (byte) (helloByte - 1);
        helloByte = (byte) (helloByte * 2);
        helloByte = (byte) (helloByte / 2);
        if (helloByte > 0) {
            for (int i = 0; i < 1; i++) {
                System.out.println(helloByte);
            }
        }
        int helloInt = 1;
        helloInt = helloInt + 1;
        helloInt = helloInt - 1;
        helloInt = helloInt * 2;
        helloInt = helloInt / 2;
        if (helloInt > 0) {
            for (int i = 0; i < 1; i++) {
                System.out.println(helloInt);
            }
        }
        long helloLong = 1L;
        helloLong = helloLong + 1L;
        helloLong = helloLong - 1L;
        helloLong = helloLong * 2;
        helloLong = helloLong / 2;
        if (helloLong > 0L) {
            for (int i = 0; i < 1; i++) {
                System.out.println(helloLong);
            }
        }
        short helloShort = 1;
        helloShort = (short) (helloShort + 1);
        helloShort = (short) (helloShort - 1);
        helloShort = (short) (helloShort * 2);
        helloShort = (short) (helloShort / 2);
        if (helloShort > 0L) {
            for (int i = 0; i < 1; i++) {
                System.out.println(helloShort);
            }
        }
        float helloFloat = 1;
        helloFloat = helloFloat + 1;
        helloFloat = helloFloat - 1;
        helloFloat = helloFloat * 2;
        helloFloat = helloFloat / 2;
        if (helloFloat > 0L) {
            for (int i = 0; i < 1; i++) {
                System.out.println(helloFloat);
            }
        }
        double helloDouble = 1D;
        helloDouble = helloDouble + 1D;
        helloDouble = helloDouble - 1D;
        helloDouble = helloDouble * 2;
        helloDouble = helloDouble / 2;
        if (helloDouble > 0L) {
            for (int i = 0; i < 1; i++) {
                System.out.println(helloDouble);
            }
        }
    }

}
