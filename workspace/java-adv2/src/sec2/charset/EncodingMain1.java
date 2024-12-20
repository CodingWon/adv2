package sec2.charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");
        encoding("A" , StandardCharsets.US_ASCII);
        encoding("A" , StandardCharsets.ISO_8859_1);
        encoding("A" , EUC_KR);
        encoding("A" , StandardCharsets.UTF_8);

        System.out.println("== 한글지원 ==");
        encoding("가" , EUC_KR);
        encoding("가" , MS_949);
        encoding("가" ,StandardCharsets.UTF_8);
        encoding("가" ,StandardCharsets.UTF_16BE);
    }

    private static void encoding(String text, Charset charset){
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);

    }
}
