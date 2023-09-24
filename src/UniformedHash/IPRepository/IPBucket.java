package UniformedHash.IPRepository;

import UniformedHash.HashEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * IP Bucket Class
 */
public class IPBucket implements Comparable<IPBucket> {

    private String originBucketIP;

    private long hashedBucketIP;

    private List<String> IPList;

    public IPBucket(String bucketIP) {
        this.originBucketIP = bucketIP;
        hashedBucketIP = HashEncoder.toHash(bucketIP);
        IPList = new ArrayList<String>();
    }

    /**
     * save IP to Bucket
     * @param ip
     * @return
     */
    public int saveIP(String ip) {
        IPList.add(ip);
        return IPList.size();
    }

    /**
     * get HashedBucket IP
     * @return
     */
    public long getHashedBucketIP() {
        return hashedBucketIP;
    }

    /**
     * get OriginBucket IP
     * @return
     */
    public String getOriginBucketIP() {
        return originBucketIP;
    }

    public List<String> getIPList() {
        return IPList;
    }

    @Override
    public int compareTo(IPBucket o) {
        return Long.compare(this.hashedBucketIP, o.hashedBucketIP);
    }
}
