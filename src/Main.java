import java.util.List;
import java.util.Random;

public class Main {

    /**
     * 안정 해시 설계를 구현해보자
     * 다음과 같은 요구사항을 충족해야 한다.
     * 1. a 개의 IP 데이터를 b 개의 서버에 분배해서 저장할 수 있어야 한다.
     * 2.해시 함수 f 를 해시 링 위에 배치하면, 가장 인접한 b 개의 서버에 저장되어야 한다.
     * 3. 서버가 추가되더라도 키 가운데 일부만 재배치되어야 한다.
     * 4. 서버가 제거되더라도 키 가운데 일부만 재배치되어야 한다.
     * 5. 키의 균등분포를 달성하기 위해서 가상 노드를 사용할 수 있어야 한다.
     * 6. 가상 노드의 개수를 조절함으로서 키의 분포를 균등하게 만들 수 있어야 한다.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("------ Program Start -----");
        System.out.println("------ Create IP Repository -----");
        // todo IP Repository 구현

        System.out.println("------ Save 1000 IP Address -----");
        // todo IP 주소를 Repository 에 저장

        System.out.println("------ Show Uniformed Ratio -----");
        // todo Bucket 별로 균등하게 분배가 됐는지 체크
    }

    /**
     * Random IP 주소를 반환한다.
     * @return
     */
    public static String generateRandomIPAddress() {
        Random rand = new Random();
        StringBuilder ipBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int segment = rand.nextInt(256); // 0부터 255까지의 랜덤 숫자 생성
            ipBuilder.append(segment);

            if (i < 3) {
                ipBuilder.append(".");
            }
        }

        return ipBuilder.toString();
    }
}