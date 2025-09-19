import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Conversation implements ConversationRequirements {

  // Attributes 
  private final List<String> transcript;
  private final Scanner UserInput;
  /**
   * Constructor 
   */
  
  Conversation() {
    this.transcript = new ArrayList<>();
    this.UserInput = new Scanner(System.in);
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    System.out.println("Start chatting!");
    
    for (int i = 0; i < 5; i++){
      String input = UserInput.nextLine();
      transcript.add("User:" + input);

      System.out.println("Thanks for saying:" + input);
    }
   
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("-----Transcript-----");
    for (String line : transcript) {
      System.out.println(line);
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    return returnString; 
  }
  
  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
