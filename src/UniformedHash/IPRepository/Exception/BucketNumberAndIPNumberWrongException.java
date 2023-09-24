package UniformedHash.IPRepository.Exception;

public class BucketNumberAndIPNumberWrongException extends Exception {

    public BucketNumberAndIPNumberWrongException() {
        super("BucketNumber And BucketIP Number List Must Have a Same Length");
    }

}
