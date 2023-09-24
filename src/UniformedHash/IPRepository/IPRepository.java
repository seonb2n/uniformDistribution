package UniformedHash.IPRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * IP 주소를 저장 및 조회 역할을 수행한다.
 *
 */
public interface IPRepository {

    /**
     * ip 를 bucket 에 저장하고 bucket 의 인덱스 번호를 반환한다.
     * @param ip
     * @return
     */
    int saveIP(String ip);

    /**
     * bucket 내 존재하는 모든 IP 주소를 가져온다.
     * @param bucketIndex
     * @return
     */
    List<String> getIP(int bucketIndex);

}
