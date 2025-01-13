package exam.day13;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class JavaWordList implements WordList{
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한합니다.
    //필드
    private List<JavaWord> words;   // 단어 저장 목록 객체
    private String filePath;
    
    public JavaWordList(String filePath) {
        System.out.println("최대 단어 저장 개수 : " + WordList.MAX_LENGTH);
        words = new ArrayList<>();
        this.filePath = filePath;
    }
    
    //새로운 단어등록, 기존단어 삭제 등의 변경사항을 파일에 저장하기
    public void fileSave(){
        PrintWriter pw =null;
        try{
            pw = new PrintWriter(this.filePath);
            for (JavaWord w : words) {
                pw.println(w.getEnglish() + " , " + w.getKorean() + " , " + w.getLevel());
            }

        }catch(Exception e){

        }finally {
            try {
                pw.close();
            } catch (Exception e) {      }
        }
    }


    //단어장.txt 에서 데이터를 읽어와서 `words 리스트에 담기`
    //   ㄴ 한 개의 라인을 읽어서 , 로 분리 -> 분리한 문자열을 각각 JavaWord 객체의 필드값으로 저장
    public void fileLoad() {    //이 메소드에서 모든 동작을 실행하도록 작성하세요.
        // String test = "public , 공용의 , 1";
        // String[] temp = test.split(",");  // 3개의 문자열로 분리된 결과가 배열에 저장
    String line=null;
    int count=0;
    FileReader fr = null;
    Scanner sc = null;
    try {
      fr = new FileReader(this.filePath);  
      sc = new Scanner(fr);  
      while(sc.hasNext()){      // 읽어올 다음 줄이 있느냐? 참이면
        line = sc.nextLine();    // 다음 줄 읽어오기
//     line 문자열을 , 로 분해하여 Javaword 객체 만들기
        String[] temp = line.split(",");
        JavaWord item = new JavaWord(temp[0].trim(), 
                                    temp[1].trim(), 
                                    Integer.parseInt(temp[2].trim()));
        words.add(item);
        // System.out.println(line);
        count++;
      }
      // System.out.println(sb.toString());
      System.out.println("읽은 단어 개수 : " + count);
    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    } finally {
      try {
        fr.close();   sc.close();
      } catch (Exception e) {    }
    }  // try catch 끝
        
    }


    // 지정된 인덱스 i 의 JavaWord 객체 리턴
    @Override
    public JavaWord getWord(int i) {
       return words.get(i);
    }

    //단어장 전체 리스트 리턴
    @Override
    public List<JavaWord> list() {     //getWords 에서 이름 변경
        return words;
    }

    //단어 추가
    @Override
    public void add(JavaWord word) {
        if(word.getEnglish() ==null || word.getEnglish().length()==0){
            System.out.println("경고 : 영어단어는 한글자 이상 입력하세요.");
        }
        words.add(word);
    }

  
    // 인자값 postion 위치부터 english 단어 찾기 : 찾은 인덱스 리턴
    @Override
    public int indexOfWord(String english,int position){
        for(int i=position;i<words.size();i++){
            if(words.get(i).getEnglish().equals(english)){   
                // 리스트에 담긴 단어의 english 필드와 비교
                return i;
            }
        }
        return -1;
    }

    //단어를 인덱스로 삭제
    @Override
    public JavaWord remove(int index) {
        if(index <0 || index >= words.size()) {
                System.out.println("경고 : 잘못된 인덱스 위치 값입니다.");
                return null;
        }        
        JavaWord item = words.remove(index);
        return item;            
    }
    
    //단어 목록 조회
    @Override
    public List<JavaWord> searchAllByEnglish(String english){
        // 같은 단어가 뜻이 여러개일 때를 예상하고 List 로 리턴.

        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    public List<JavaWord> searchAllByLevel(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getLevel()==level ) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }
    // 인스턴스 메소드 : 인스턴스 필드 words 를 사용하여 동작.
    @Override
    public void print(){
        for(JavaWord word : words) {
            System.out.println(String.format("%-20s %-30s %20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
   
    // 출력 메소드 
    // static 메소드 : 인스턴스 필드를 사용하지 않고 메소드 인자를 받아 동작.
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
}