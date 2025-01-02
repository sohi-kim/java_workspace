package object.day6;

// 커스텀 생성자, getter, setter 활용합니다.
public class MyMathV2 {

    private int first;
    private int second;
    private char op;        //operator 연산자 : '+','-','*' 만 가능하도록 제한
    private long answer;

    //1. 커스텀 생성자 : first, second, op 3개 인스턴스 변수 초기화
    public MyMathV2(int first, int second, char op) {
      this.first = first;
      this.second = second;
      // this.op = op;
      setOp(op);
    }

    //2. getter
    public int getFirst() {
      return this.first;
    }

    public int getSecond() {
      return this.second;
    }

    public char getOp() {
      return this.op;
    }

    public long getAnswer() {
      return this.answer;
    }

    //3. setter
    public void setFirst(int first) {
      this.first = first;
    }

    public void setSecond(int second) {
      this.second = second;
    }

    public void setOp(char op) {
      if(op=='+' || op=='-' || op =='*')
          this.op = op;        
      else
          this.op = '?';    
    }

    public void setAnswer(long answer) {
      this.answer = answer;
    }

    // 인스턴스 필드값으로 문자열 리턴
    public String toString(){
      return String.format("%d %c %d = %d", 
                  this.first, this.op, this.second,calculate());
    }

    // 필요에 의한 계산 메소드
    public long calculate(){
      // this.op 값에 따라 연산 덧셈, 뺄셈, 곱셈 중 하나 실행하여 리턴하기
      long result =0;
      switch (this.op) {
        case '+':
          result = this.first + this.second;
          break;
        case '-':
          result = this.first - this.second;
          break;
        case '*':
          result = this.first * this.second;
          break;
        default:
          break;
      }
      return result;
    }

}
