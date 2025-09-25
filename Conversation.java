import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Conversation implements ConversationRequirements {

  // Attributes 
  private final List<String> transcript;
  private final Scanner UserInput;
  /**
   * Constructor 
   */
  
  Conversation() {
    this.transcript = new ArrayList<>(); //transcript is defined as a list which objects are added to later
    this.UserInput = new Scanner(System.in);
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    System.out.println("How Many Rounds!"); //Asks how many rounds the player wants
    int numRounds = Integer.parseInt(UserInput.nextLine()); //stores the number of rounds the player wants
    System.out.println("Hi There! I'd love to chat. Please type in all lowercase letters. What's on your mind?"); // starts the game and informs player of game rules
    
    for (int i = 0; i < numRounds; i++){ //creates a loop where the game can be played for the number of rounds the player specified
      String input = UserInput.nextLine();//user inputs a string of a starting phrase
      transcript.add("User: " + input); //user input is added to transcript

      String response = input;//response is a variation of input
      boolean matched = false; //defines a boolean that determines if certain words match in the input to the specified word passed through contains
      if(input.contains("i ")){//this condition is only considered if the user input contains "i "
        response = input.replace("i ", "you "); //if input contains "i " then make the response the same as the input except replace " i" with "you "
        matched = true;// it is true that the input contains " i"
      }
      if(input.contains("me ")){
        response = input.replace("me", "you");
        matched = true;
      }
      if(input.contains("am ")){
        response = input.replace("am", "are");
        matched = true;
      }
      if(input.contains("are ")){
        response = input.replace("are", "am");
        matched = true;
      }
      if(input.contains("you ")){
        response = input.replace("you", "I");
        matched = true;
      }
      if(input.contains("my")){
        response = input.replace("my", "your");
        matched = true;
      }
      if(input.contains("your ")){
        response = input.replace("your", "my");
        matched = true;
      }
      if(input.contains("mine ")){
        response = input.replace("mine", "yours");
        matched = true;
      }
      if (!matched){ // if the input does not contain any of the above words
        List<String> randomResponse = new ArrayList<>(); //create a list of random responses
        randomResponse.add("Thanks for saying: " + input);
        randomResponse.add("I don't understand: " + input + ". Please say something else");
        randomResponse.add("Well that's great! I guess...");
        randomResponse.add("Well this is awkward because I've got nothing to say to that...");

        //define the response when matched = false to be a random item from the list randomResponse
        Random r = new Random();
        int randomitem = r.nextInt(randomResponse.size());
        response = randomResponse.get(randomitem);
      }
      System.out.println(response); //print out response
      transcript.add("Computer: " + response); //add response to transcript
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
