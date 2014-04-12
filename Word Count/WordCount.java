/*============================
 *=Author : wtarr            =
 *=                          =
 *=  Title: WordCount WEB    = 
 *=                          =
 *============================
 */
 
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.*;
import javax.swing.event.*;

public class WordCount extends JPanel implements ActionListener{
	//================================
	//==========The variables=========
	//================================
	
   //The highlighter ForeColor
   private Color  myHighlightColor = new Color(0x80, 0x80, 0xFF); //Very Light Blue
   //The highlighter Backcolor
   private Color entryBg;
   //Create a highlighter object
   private Highlighter Highlight_this;
   private Highlighter.HighlightPainter painter;
	
	//class wide componets
	private Toolkit toolkit;
	
	//Create a text area	
	JTextArea textArea = new JTextArea("");

	//Create a Enter Word textfield
	private JTextField enterWord = new JTextField("");
	
	//Create a Status textfield
	private JTextField status = new JTextField("");
	
	//Create a number of words textField
	private JTextField NumOfWords = new JTextField("");
	
	//Create a number of characters including spaces textField
	private JTextField CharsWithSpaces = new JTextField("");
	
	//Create a number of characters excluding spaces textField
	private JTextField CharsWithoutSpaces = new JTextField("");
		
	//Create a number of paragraphs textField
	private JTextField numOfPara = new JTextField("");
	
	//Create the Word to locate textField
	private JTextField word = new JTextField("");
	
	//Find Word Button
	JButton findWord = new JButton("Find Word");
	
	//Find Clear Button
	JButton clear = new JButton("Clear");
	
	//Find WordCount Button
	JButton wordCount = new JButton("Word Count");
	
	//Create a string buffer
	StringBuffer myString;
	
	//=================================================================
	//================== C O N S T R U C T O R ========================
	//=================================================================
		
	WordCount(){
	  
      super (new FlowLayout	());
      this.setBackground(Color.LIGHT_GRAY);
      this.add(this.createpanel1());
   
            
      //Apply Listener and ToolTip to the buttons
      findWord.addActionListener(this);
	  findWord.setToolTipText("Find Word"); 
	  clear.addActionListener(this);
	  clear.setToolTipText("Clear");
	  wordCount.addActionListener(this);
	  wordCount.setToolTipText("Word Count");
	  textArea.setToolTipText("Enter text here");
	  NumOfWords.setToolTipText("Number of words in text");
	  CharsWithSpaces.setToolTipText("Number of characters including spaces");
	  CharsWithoutSpaces.setToolTipText("Number of characters excluding spaces");
	  numOfPara.setToolTipText("Number of paragraphs"); 
	  word.setToolTipText("Enter the word to find here"); 
     
       //Create a new highlighter
       Highlight_this = new DefaultHighlighter();
       painter = new DefaultHighlighter.DefaultHighlightPainter(myHighlightColor);
       //Assign the highlighter to the textArea
       textArea.setHighlighter(Highlight_this);
     
       entryBg = word.getBackground();
      
          
	}
	
	//=================================================================
	//================== T H E   P A N E L S ==========================
	//=================================================================
	public JPanel createpanel1(){ 
	
	
	//--------------------------------Right hand side ------------------------------------
	//Create the borders
	javax.swing.border.Border b_enterText = BorderFactory.createEmptyBorder(2,2,2,2); //Enter Text
    javax.swing.border.Border b_textArea = BorderFactory.createEmptyBorder(2,2,2,2); //Text Area
    javax.swing.border.Border b_CountOfWordsLbl = BorderFactory.createEmptyBorder(2,2,2,2); //Count of words and characters label
    javax.swing.border.Border b_numOfWordsLbl = BorderFactory.createEmptyBorder(2,2,2,2); //Number of words label
    javax.swing.border.Border b_CharsWithSpacesLbl = BorderFactory.createEmptyBorder(2,2,2,2); //Number of characters including spaces label
    javax.swing.border.Border b_CharsWithoutSpacesLbl = BorderFactory.createEmptyBorder(2,2,2,2); //Number of characters without spaces label
    javax.swing.border.Border b_numOfParaLbl = BorderFactory.createEmptyBorder(2,2,2,2); //Number of paragraphs label
	javax.swing.border.Border b_NumOfWords = BorderFactory.createEmptyBorder(2,100,2,2); //Number of words textfield	
	javax.swing.border.Border b_CharsWithSpaces = BorderFactory.createEmptyBorder(2,100,2,2); //Number of chars including spaces textfield		
	javax.swing.border.Border b_CharsWithoutSpaces = BorderFactory.createEmptyBorder(2,100,2,2); //Number of chars including spaces textfield		
	javax.swing.border.Border b_numOfPara = BorderFactory.createEmptyBorder(2,100,2,2); //Number of paragraphs textfield	
	javax.swing.border.Border b_panel1 = BorderFactory.createEmptyBorder(2,2,2,2); //Panel1
	javax.swing.border.Border b_panel2 = BorderFactory.createEmptyBorder(2,2,2,2); //Panel2
	javax.swing.border.Border b_panel3 = BorderFactory.createEmptyBorder(2,2,2,2); //Panel2	
	javax.swing.border.Border Loweredbeveled = BorderFactory.createLoweredBevelBorder(); //Sunken Beveled panel	
		
		
	//"Enter Text"
	JPanel p_enterText = new JPanel(new GridLayout(1,1));
	p_enterText.setBorder(b_enterText);
	p_enterText.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
	
	JLabel enterText = new JLabel("Enter text");
	enterText.setFont(new Font("sansserif", Font.BOLD, 12));
	enterText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	
	p_enterText.add(enterText);
	
	
		
	//******TextArea*******
	JPanel p_textArea = new JPanel(new GridLayout(1,1));
   //p_textArea.setBorder(b_textArea);
   p_textArea.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
	textArea.setFont(new Font("sansserif", Font.PLAIN, 12));
	textArea.setLineWrap(true);
	textArea.setWrapStyleWord(true);

   //Create a scroll pane and assign it to the textArea
   //then disable it
   JScrollPane scrollingResult = new JScrollPane(textArea);
	scrollingResult.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollingResult.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
   p_textArea.add(scrollingResult);
   
  
  	
   JPanel p_textArea_beveled = new JPanel(new GridLayout(1,1));
   p_textArea_beveled.setBorder(Loweredbeveled);
   p_textArea_beveled.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
   p_textArea_beveled.add(p_textArea); 



    
    //******Count of words and characters Label*******
    JPanel p_CountOfWordsLbl = new JPanel(new GridLayout(1,1));
    p_CountOfWordsLbl.setBorder(b_CountOfWordsLbl);
    p_CountOfWordsLbl.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
    
    JLabel CountOfWordsLbl = new JLabel("Count of words and characters");
    CountOfWordsLbl.setFont(new Font("sansserif", Font.BOLD, 12));
    CountOfWordsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    
	p_CountOfWordsLbl.add(CountOfWordsLbl);
	
	
	
	//******Number of Words********
	JPanel p_numOfWordsLbl = new JPanel(new GridLayout(1,1));
	p_numOfWordsLbl.setBorder(b_numOfWordsLbl);
	p_numOfWordsLbl.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
	
	JLabel numOfWordsLbl = new JLabel("Number of words");
    numOfWordsLbl.setFont(new Font("sansserif", Font.PLAIN, 12));
    numOfWordsLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    
    p_numOfWordsLbl.add(numOfWordsLbl);
    
    
    //******Number of characters including spaces label*******
   JPanel p_CharsWithSpacesLbl = new JPanel(new GridLayout(1,1));
	p_CharsWithSpacesLbl.setBorder(b_CharsWithSpacesLbl);
	p_CharsWithSpacesLbl.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
	
	JLabel CharsWithSpacesLbl = new JLabel("Number of characters including spaces");
    CharsWithSpacesLbl.setFont(new Font("sansserif", Font.PLAIN, 12));
    CharsWithSpacesLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    
    p_CharsWithSpacesLbl.add(CharsWithSpacesLbl);
    
    
    //*******Number of characters excluding spaces label******
    JPanel p_CharsWithoutSpacesLbl = new JPanel(new GridLayout(1,1));
	p_CharsWithoutSpacesLbl.setBorder(b_CharsWithoutSpacesLbl);
	p_CharsWithoutSpacesLbl.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
	
	JLabel CharsWithoutSpacesLbl = new JLabel("Number of characters without spaces");
    CharsWithoutSpacesLbl.setFont(new Font("sansserif", Font.PLAIN, 12));
    CharsWithoutSpacesLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    
    p_CharsWithoutSpacesLbl.add(CharsWithoutSpacesLbl);
    
    //*********Number of paragraphs label*********
   JPanel p_numOfParaLbl = new JPanel(new GridLayout(1,1));
	p_numOfParaLbl.setBorder(b_numOfParaLbl);
	p_numOfParaLbl.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
	
	JLabel numOfParaLbl = new JLabel("Number of paragraphs");
    numOfParaLbl.setFont(new Font("sansserif", Font.PLAIN, 12));
    numOfParaLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    
    p_numOfParaLbl.add(numOfParaLbl);
    
    
    //*******NumOfWords text field**********
   JPanel p_NumOfWords_beveled = new JPanel(new GridLayout(1,1));
   p_NumOfWords_beveled.setBorder(Loweredbeveled);
   p_NumOfWords_beveled.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
   NumOfWords.setEditable(false);
   p_NumOfWords_beveled.add(NumOfWords); 
    
   JPanel p_NumOfWords = new JPanel(new GridLayout(1,1));
   p_NumOfWords.setBorder(b_NumOfWords);
   p_NumOfWords.setBackground(Color.LIGHT_GRAY);
   p_NumOfWords.add(p_NumOfWords_beveled);
    
   
    
    
    //*****CharsWithSpaces text field*********
    
   JPanel p_CharsWithSpaces_beveled = new JPanel(new GridLayout(1,1));
   p_CharsWithSpaces_beveled.setBorder(Loweredbeveled);
   p_CharsWithSpaces_beveled.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
   CharsWithSpaces.setEditable(false);
   p_CharsWithSpaces_beveled.add(CharsWithSpaces); 
    
   JPanel p_CharsWithSpaces = new JPanel(new GridLayout(1,1));
   p_CharsWithSpaces.setBorder(b_CharsWithSpaces);
   p_CharsWithSpaces.setBackground(Color.LIGHT_GRAY);
   CharsWithSpaces.setEditable(false);
   p_CharsWithSpaces.add(p_CharsWithSpaces_beveled);
    
    
    //*****CharsWithoutSpaces text field*********
   JPanel p_CharsWithoutSpaces_beveled = new JPanel(new GridLayout(1,1));
   p_CharsWithoutSpaces_beveled.setBorder(Loweredbeveled);
   p_CharsWithoutSpaces_beveled.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
   CharsWithoutSpaces.setEditable(false);
   p_CharsWithoutSpaces_beveled.add(CharsWithoutSpaces); 
    
    JPanel p_CharsWithoutSpaces = new JPanel(new GridLayout(1,1));
    p_CharsWithoutSpaces.setBorder(b_CharsWithoutSpaces);
    p_CharsWithoutSpaces.setBackground(Color.LIGHT_GRAY);
    p_CharsWithoutSpaces.add(p_CharsWithoutSpaces_beveled);
     
    //******numOfPara text field*******
   JPanel p_numOfPara_beveled = new JPanel(new GridLayout(1,1));
   p_numOfPara_beveled.setBorder(Loweredbeveled);
   p_numOfPara_beveled.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
   numOfPara.setEditable(false);
   p_numOfPara_beveled.add(numOfPara); 
    
    JPanel p_numOfPara = new JPanel(new GridLayout(1,1));
    p_numOfPara.setBorder(b_numOfPara);
    p_numOfPara.setBackground(Color.LIGHT_GRAY);
    p_numOfPara.add(p_numOfPara_beveled);
    
    
    //Bulid the panel that holds "Enter text", Text area & "Count of words and characters label"
    JPanel panel1 = new JPanel(new BorderLayout());
	panel1.setBorder(b_panel1);
	panel1.setBackground(Color.LIGHT_GRAY);
	
	panel1.add(p_enterText, BorderLayout.NORTH);
	panel1.add(p_textArea_beveled, BorderLayout.CENTER);
	panel1.add(p_CountOfWordsLbl, BorderLayout.SOUTH);
       
       
       
    JPanel panel2 = new JPanel(new GridLayout(4, 4));
    panel2.setBorder(b_panel2);
	panel2.setBackground(Color.LIGHT_GRAY);
        
    panel2.add(p_numOfWordsLbl);
    panel2.add(p_NumOfWords);
    panel2.add(p_CharsWithSpacesLbl);
    panel2.add(p_CharsWithSpaces);
    panel2.add(p_CharsWithoutSpacesLbl);
    panel2.add(p_CharsWithoutSpaces);
    panel2.add(p_numOfParaLbl);
    panel2.add(p_numOfPara);
    
    
    JPanel panel3 = new JPanel(new GridLayout(2,1));
	panel3.setBorder(b_panel3);
	panel3.setBackground(Color.LIGHT_GRAY);
	panel3.add(panel1);
	panel3.add(panel2);
	
	
	
	
    
    //--------------------------Left Hand Side-----------------------------
    
    //Create some more border styles
    javax.swing.border.Border b_EnterWordLbl = BorderFactory.createEmptyBorder(2,50,2,50); //Enter a word label	
    javax.swing.border.Border b_word = BorderFactory.createEmptyBorder(2,50,2,50); //Enter a word label
    javax.swing.border.Border b_statusLbl = BorderFactory.createEmptyBorder(2,50,2,50); //Enter a word label    
    javax.swing.border.Border b_status = BorderFactory.createEmptyBorder(2,50,2,50); //Enter a word label
    
    javax.swing.border.Border b_wordBtn = BorderFactory.createEmptyBorder(30,60,30,30); //Find word button
    javax.swing.border.Border b_clearBtn = BorderFactory.createEmptyBorder(30,30,30,60); //Clear button
    javax.swing.border.Border b_wordCountBtn = BorderFactory.createEmptyBorder(30,100,30,100); //WordCount button
    
    javax.swing.border.Border bvl_wordBtn = BorderFactory.createRaisedBevelBorder(); //Find word button
    javax.swing.border.Border bvl_clearBtn = BorderFactory.createRaisedBevelBorder(); //Clear button
    javax.swing.border.Border bvl_wordCountBtn = BorderFactory.createRaisedBevelBorder(); //WordCount button
    
    
    javax.swing.border.Border b_panelA = BorderFactory.createEmptyBorder(2,2,2,2); //
    javax.swing.border.Border b_panelB = BorderFactory.createEmptyBorder(2,2,2,2); //
    javax.swing.border.Border b_panelC = BorderFactory.createEmptyBorder(2,2,2,2); //
    javax.swing.border.Border b_panel4 = BorderFactory.createEmptyBorder(2,2,2,2); //
    
   
    
   //*******Enter Word label*******
   JPanel p_EnterWordLbl = new JPanel(new GridLayout(1,1));
   p_EnterWordLbl.setBorder(b_EnterWordLbl);
	p_EnterWordLbl.setBackground(Color.LIGHT_GRAY);
    
    JLabel enterWordlbl = new JLabel("Enter word");
    enterWordlbl.setFont(new Font("sansserif", Font.BOLD, 12));
    enterWordlbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    
    p_EnterWordLbl.add(enterWordlbl);
    
    
    //*****theWord text field*******
   JPanel p_word_beveled = new JPanel(new GridLayout(1,1));
   p_word_beveled.setBorder(Loweredbeveled);
   p_word_beveled.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
   word.setEditable(true);
   p_word_beveled.add(word); 
    
    JPanel p_word = new JPanel(new GridLayout(1,1));
    p_word.setBorder(b_word);
    p_word.setBackground(Color.LIGHT_GRAY);
    p_word.add(p_word_beveled);
    
    
    //******Status label********
   JPanel p_statusLbl = new JPanel(new GridLayout(1,1));
   p_statusLbl.setBorder(b_statusLbl);
	p_statusLbl.setBackground(Color.LIGHT_GRAY);
    
    JLabel statusLbl = new JLabel("Status");
    statusLbl.setFont(new Font("sansserif", Font.BOLD, 12));
    statusLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    
    p_statusLbl.add(statusLbl);
    
    
    //*******status text field**********
   JPanel p_status_beveled = new JPanel(new GridLayout(1,1));
   p_status_beveled.setBorder(Loweredbeveled);
   p_status_beveled.setBackground(Color.LIGHT_GRAY); //Set panel background to light grey
   status.setEditable(false);
   p_status_beveled.add(status); 
    
    JPanel p_status = new JPanel(new GridLayout(1,1));
    p_status.setBorder(b_status);
    p_status.setBackground(Color.LIGHT_GRAY);
    p_status.add(p_status_beveled);
    
    
    
    //*******Find Word button*********
     JPanel p_wordBtn_bvl = new JPanel(new GridLayout(1,1));
    p_wordBtn_bvl.setBorder(bvl_wordBtn);
    p_wordBtn_bvl.setBackground(Color.LIGHT_GRAY);
    findWord.setBackground(Color.LIGHT_GRAY);
    p_wordBtn_bvl.add(findWord);
    
    JPanel p_wordBtn = new JPanel(new GridLayout(1,1));
    p_wordBtn.setBorder(b_wordBtn);
    p_wordBtn.setBackground(Color.LIGHT_GRAY);
    p_wordBtn.add(p_wordBtn_bvl);
    
    
    //*******Find Clear button*******
     JPanel p_clearBtn_bvl = new JPanel(new GridLayout(1,1));
    p_clearBtn_bvl.setBorder(bvl_clearBtn);
    p_clearBtn_bvl.setBackground(Color.LIGHT_GRAY);
    clear.setBackground(Color.LIGHT_GRAY);
    p_clearBtn_bvl.add(clear);
            
    JPanel p_clearBtn = new JPanel(new GridLayout(1,1));
    p_clearBtn.setBorder(b_clearBtn);
    p_clearBtn.setBackground(Color.LIGHT_GRAY);
    p_clearBtn.add(p_clearBtn_bvl);
    
    
	//*******WordCount button***********
	 JPanel p_wordCountBtn_bvl = new JPanel(new GridLayout(1,1));
    p_wordCountBtn_bvl.setBorder(bvl_wordCountBtn);
    p_wordCountBtn_bvl.setBackground(Color.LIGHT_GRAY);
    wordCount.setBackground(Color.LIGHT_GRAY);
    p_wordCountBtn_bvl.add(wordCount);
		
    JPanel p_wordCountBtn = new JPanel(new GridLayout(1,1));
    p_wordCountBtn.setBorder(b_wordCountBtn);
    p_wordCountBtn.setBackground(Color.LIGHT_GRAY);
    p_wordCountBtn.add(p_wordCountBtn_bvl);;
	
		
	//*********Build panel A**********
	JPanel panelA = new JPanel(new GridLayout(4,1));
	panelA.setBorder(b_panelA);
	panelA.setBackground(Color.LIGHT_GRAY);
	
	panelA.add(p_EnterWordLbl); //Enter the word label
	panelA.add(p_word);         //The word to be found textfield
	panelA.add(p_statusLbl);    //The status label
	panelA.add(p_status);       //The status textfield
	
		
	//********Find Word button & Clear button******
	JPanel panelB = new JPanel(new GridLayout(1,2));
	panelB.setBorder(b_panelB);
	panelB.setBackground(Color.LIGHT_GRAY);
	
	panelB.add(p_wordBtn);
	panelB.add(p_clearBtn);
	
	//**********The Word Count button********
	JPanel panelC = new JPanel(new GridLayout(1,1));
	panelC.setBorder(b_panelC);
	panelC.setBackground(Color.LIGHT_GRAY);
	
	panelC.add(p_wordCountBtn);
	
	//Build the panel
	JPanel panel4 = new JPanel(new GridLayout(3,1));
	panel4.setBorder(b_panel4);
	panel4.setBackground(Color.LIGHT_GRAY);
	
	panel4.add(panelA);
	panel4.add(panelB);
	panel4.add(panelC);
	
	JPanel FILLER = new JPanel();
	FILLER.setBackground(Color.LIGHT_GRAY);
	

	
	
	
	//-------------------Build the Main panel-----------------------
	
	JPanel main = new JPanel(new BorderLayout());
	
	
	main.add(panel3, BorderLayout.WEST); //Right hand side
	main.add(FILLER, BorderLayout.CENTER); //A packer
	main.add(panel4, BorderLayout.EAST); //Left hand side
	
	return main;
	
	}
	//=================================================================	
	//=================A C T I O N   L I S T E N E R ==================
	//=================================================================
	
		public void actionPerformed(ActionEvent event){
		//this one event trap is called any of the buttons are pressed
		//we nedd to differentiate between which button was pressed
		//to do this we can use the getActionCommand() method
		
		if (event.getActionCommand().equals("Find Word")){
		
		//System.out.println("Find Word - Working");
		
		//Find word method
		findWord();
		
		} else if (event.getActionCommand().equals("Clear")){
			
		//System.out.println("Clear - Working");
			
		clear();
			
		} else if (event.getActionCommand().equals("Word Count")){
		//System.out.println("wordCount - Working");
		
		wordCount();
		
		}
		
		} //End actionListener
		
		//====================================================================
		//================== F I N D   W O R D  M E T H O D ==================
		//====================================================================
		
		public void findWord(){
		
		String w = word.getText();
		String tArea = textArea.getText();
		
		textArea.setText(tArea);
		status.setText("");
						
		
							
		if (((w.length() <= 0) & (tArea.length() <= 0)) | (w.length() <= 0) |(tArea.length() <= 0)  )  { //Contains text? 
		
		//No text then
		//
		//Do Nothing
		//    &
		//EXIT Method now
		
		return; 
		
		} else {
		
		//Easy way
		//Highlight_this.removeAllHighlights();
		
		//Remove all highlighting
		myString = new StringBuffer(tArea);
				
		//Assign the index of the position
		//of the first character in
		//the word to be found to the variable 						
		int location = myString.indexOf(w);
		
		//Add 1 to that as having an index of 0
		//is not suitable for the end user
		int Thelocation = location + 1;
		
		//This varaible is used for formatting the 
		//the appearence of the status
		String loc = "";
		
		//Format the output to appear as "Word found at: nnn"
		if ((Thelocation >= 0) & (Thelocation < 10)){ //0 - 9
			
			loc = "00" + Integer.toString(Thelocation);
			
		} else if((Thelocation >= 10) & (Thelocation < 99)){ //10 - 99
			
			loc = "0" + Integer.toString(Thelocation); 
			
		} else if (Thelocation > 99){ //Everything else
			 
			 loc = Integer.toString(Thelocation);
			 
		}
		
		//If a word is found then the staus output will
		//be blue									
		status.setForeground(Color.BLUE);
		status.setText("Word found at: " + loc);
		
		int start = location; //The index to the start of the word
		int end = location + w.length(); //The index to the end of the word		 
		
		    
		try {               
                Highlight_this.addHighlight(start, end, painter);
                textArea.setCaretPosition(start);
                word.setBackground(entryBg);
                
            } catch (BadLocationException e) {
                
                e.printStackTrace();
                
            }	
		
		if (location == -1) {
			
			
		status.setForeground(Color.RED);
		status.setText("Word not found");
		Highlight_this.removeAllHighlights();	
			
		}
						
		}	
			
			
		} //find word
		
	//==========================================================	
	//====================== C L E A R =========================
	//==========================================================
	
		public void clear(){
			
			Highlight_this.removeAllHighlights(); //Remove the highligthing
				
			textArea.setText(""); //Reset the text area
			word.setText(""); //Reset the "Enter Word" textfield
			status.setText("");//Reset the "Status" textField
			
			NumOfWords.setText(""); //Reset the "Number of words" textField
			CharsWithSpaces.setText(""); //Reset the "Number of characters including spaces" textField
			CharsWithoutSpaces.setText(""); //Reset the "Number of characters without spaces" textField
		   numOfPara.setText(""); //Reset the "Number of Paragraphs" textField
		   
		   wordCount.setEnabled(true);
		}
	//==========================================================	
	//================= W O R D   C O U N T ====================
	//==========================================================
	
	public void wordCount(){
	
	String text = textArea.getText();
				
	if (text.length() <= 0)  { //TextArea Contains text? no...
	
	//Exit method - Do nothing
	return;
	
	} else { //Ok - Proceed
	
	char holder; //Temporary holder for the character under analysis
	int CountAllChars = 0; //text.length(); //The length of the string (all the text contained within the textArea)
	int spaces = 0; //For count of spaces
	int CountW_O_spaces = 0; //For counting the total number of characters excluding spaces
	int wordCounter = 0; //For counting the number of words
	int paraCounter = 0; //For counting the number of paragraphs (There will always be at least one paragraph)
	int carrRetCounter = 0; //Counting the  number of carriage returns


	
	boolean spaceDetected = false; //For if a space is detected
	boolean second_space_Detected = false; //For if a second space is detected
	
	//---------------------------------Count the number of characters-------------------------------
	
	for (int a = 0 ; a < (text.length()) ; a++) { //for each character in the entered string sample
	
	holder = text.charAt(a); // add that character at index (a) and add it to the holder.
	
	if ((holder >= 32) & (holder <=126)) { //'Space' - 'Z'
		
		CountAllChars++; 
		
	}
		
	} //For
	
	
	
	//-------------------------------Count the number of spaces--------------------------------------
	
	for (int a = 0 ; a < (text.length()) ; a++) { //for each character in the entered string sample
	
	holder = text.charAt(a); // add that character at index (a) and add it to the holder.
	
	if (holder == 32) {
		
		spaces++; 
		
	}
		
	} //For
			
	

	//------------Counting number of characters without spaces-------------------
		 
	 CountW_O_spaces = CountAllChars - spaces;
	 
	 
	//-----------------------counting the words----------------------------------
	/*This works by counting the number of spaces contained within the string 
	 *if more than one space is found it will not be counted
	 *the wordCounter is incremented once at the end to take account of
	 *the last word.
	 */
	 	 	 
	for (int a = 0 ; a < (text.length()) ; a++) { //for each character in the entered string sample
	
	holder = text.charAt(a); // add that character at index (a) and add it to the holder.
	
	//Boolean isLetter = Character.isLetter(holder);
	spaceDetected = Character.isWhitespace(holder);
	
	if (spaceDetected == true) { 
		
		if (second_space_Detected == false){
	
			wordCounter++;
			
			second_space_Detected = true;
			
			}
		
	} 
	
	if ((holder >= 33) & (holder <=126)){
		
		second_space_Detected = false;
		
	}	
						
	} //For
				
	
	//---------------------------Count the number of paragraphs----------------------------
		for (int a = 0 ; a < (text.length()) ; a++) { //for each character in the entered string sample
	
	holder = text.charAt(a); // add that character at index (a) and add it to the holder.
			
	if (holder == '\n') { 
				
		paraCounter++;
		
								}
		
	} //For
	
	
	if (text.length() <= 0) {
	
	paraCounter = 0;
	
	}
		
	//Display the results
	
   //If last char is not a 'SPACE'{
	
	if (text.charAt(text.length() - 1) != 32) {
		
	wordCounter++; //One for the end
	
	}
	
	//If last char is not a '\n'
	
	if (text.charAt(text.length() - 1) == '\n') {
		
	paraCounter++; //One for the end
	
	}


//If the first character is 
//a SPACE do not count it as 
//a word
	if (text.charAt(0) == 32){
		
   	wordCounter--;
		System.out.print("sPACE");
		
 }
 
  

//	If the first character is
//	a NEW LINE then do
//	not count it as a word
	
if (text.charAt(0) == 10){
		System.out.print("1 deducted");

		wordCounter--;
}
	
		
	
	NumOfWords.setText(Integer.toString(wordCounter));
		
	CharsWithSpaces.setText(Integer.toString(CountAllChars));
	
	CharsWithoutSpaces.setText(Integer.toString(CountW_O_spaces));
		
	numOfPara.setText(Integer.toString(paraCounter));
	
	
	
	wordCount.setEnabled(false);
	 
	} //Else proceed
			
	}  //Word count
	
	
}//End class