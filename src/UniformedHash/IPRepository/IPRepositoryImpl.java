package UniformedHash.IPRepository;

import UniformedHash.HashEncoder;
import UniformedHash.IPRepository.Exception.BucketNumberAndIPNumberWrongException;
import java.util.Arrays;
import java.util.List;

public class IPRepositoryImpl implements IPRepository {

    IPBucket[] ipBucketArray;

    /**
     * IP 저장소를 생성한다.
     * @param bucketNumber
     * @param bucketIPList
     * @throws BucketNumberAndIPNumberWrongException
     */
    public IPRepositoryImpl(int bucketNumber, String[] bucketIPList) throws BucketNumberAndIPNumberWrongException {
        if (bucketNumber != bucketIPList.length) {
            throw new BucketNumberAndIPNumberWrongException();
        }
        this.ipBucketArray = new IPBucket[bucketNumber];

        for (int i = 0; i < bucketNumber; i++) {
            ipBucketArray[i] = new IPBucket(bucketIPList[i]);
        }
        Arrays.sort(ipBucketArray);
    }

    @Override
    public int saveIP(String ip) {
        long hashedIP = HashEncoder.toHash(ip);
        int bucketIndex = 0;
        // bucket 은 원 위에 노드이다. 가장 마지막 버킷보다 큰 hash 값은 0 번째 버킷에 소속되어야 한다.
        if (hashedIP > ipBucketArray[ipBucketArray.length - 1].getHashedBucketIP()) {
            ipBucketArray[0].saveIP(ip);
            return 0;
        }
        for (int i = 0; i < ipBucketArray.length; i++) {
            if (ipBucketArray[i].getHashedBucketIP() > hashedIP) {
                ipBucketArray[i].saveIP(ip);
                bucketIndex = i;
                break;
            }
        }
        return bucketIndex;
    }

    @Override
    public List<String> getIP(int bucketIndex) throws IndexOutOfBoundsException {
        return ipBucketArray[bucketIndex].getIPList();
    }
}
