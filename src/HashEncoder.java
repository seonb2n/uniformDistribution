public class HashEncoder {

    private static final int HASH_KEY = 31;

    /**
     * IP 주소를 받아서 해시값으로 변환 후 반환한다.
     * @param ipAddress
     * @return
     */
    public static long toHash(String ipAddress) {
        long hashValue = 0;
        for (int i = 0; i < ipAddress.length(); i++) {
            char c = ipAddress.charAt(i);
            hashValue = (hashValue * HASH_KEY) + c;
        }
        return hashValue;
    }

}
