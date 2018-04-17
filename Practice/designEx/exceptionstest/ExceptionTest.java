package design.practice.designEx.exceptionstest;


/**
 * Hello world!
 *
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            returnCheckedException();
        } catch (CheckedException e) {
            
        }
    }
    
    public void compareTwoNumbers(int a, int b) throws CheckedException {
        if(a > b){
            returnUncheckedException();
        }else{
            returnCheckedException(); //We Must Add throws to this Method
        }
    }
    
    public void returnUncheckedException() throws UncheckedException{
        throw new UncheckedException();
    }
    
    public static void returnCheckedException() throws CheckedException{
        throw new CheckedException();
    }
    
    
}
