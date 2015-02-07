 // 
 // Project 4 
 // Name: Josh Kang, Nicholas Nathan, Tyler Phelan, Michael Sikes, Jill Weakland
 // E-mail: jk1591,  nrn2, tap46, mhs65, jlw264
 // Instructor: Singh 
 // COSC 150 
 // 
 // In accordance with the class policies and Georgetown's Honor Code, 
 // I certify that, with the exceptions of the lecture notes and those 
 // items noted below, I have neither given nor received any assistance 
 // on this project. 
 // 
 // Description: <Describe your program> 
 // 

import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.*;
 

public class Program extends JApplet {
	
   private IntroScreen introScreen;
   private MoneyLesson moneyLesson;
   private SavingLesson savingLesson;
   private InterestLesson interestLesson;
   private MarketLesson marketLesson;
   private StocksLesson stocksLesson;
   private RiskLesson riskLesson;
   
   //Simulation launcher
   private SimulatorStart simulatorStart;
   
   //Simulation Views
   private Simulation simulation;
   //All listeners
   ActionListener nextButtonListener;
   ActionListener backButtonListener;
   ActionListener goToIntroScreenListener;
   ActionListener goToGameStartListener;
   ActionListener simDoneButtonListener;
   ActionListener simResetButtonListener;
   ActionListener simExBackButtonListener;
   ActionListener simCandyInfoButtonListener;
   ActionListener simToysInfoButtonListener;
   ActionListener simPetInfoButtonListener;
   ActionListener simAddStarButtonListener;
   ActionListener simEndButtonListener;
   
   
   
   private SimulationExplanation simExplanation;
   
   //Simulation Model
   private SimulationCalculator simCalculator;
   
   //Simulation Controller
   private SimulationController simController;
   
   //Set layout
   private CardLayout cardlayout = new CardLayout();
 
   //Create game
   public void init() {
      setLayout(cardlayout);
      setSize(1200, 700);

      makeListeners();


        
     
       
 
      //Create class objects and add action listeners
      introScreen = new IntroScreen();
      introScreen.addStartLessonActionListener(nextButtonListener);
      introScreen.addStartGameActionListener(goToGameStartListener);
      
      
      moneyLesson = new MoneyLesson();
      moneyLesson.addNextActionListener(nextButtonListener);
      moneyLesson.addBackActionListener(backButtonListener);
      savingLesson = new SavingLesson();
      savingLesson.addNextActionListener(nextButtonListener);
      savingLesson.addBackActionListener(backButtonListener);
      interestLesson = new InterestLesson();
      interestLesson.addNextActionListener(nextButtonListener);
      interestLesson.addBackActionListener(backButtonListener);
      stocksLesson = new StocksLesson();
      stocksLesson.addNextActionListener(nextButtonListener);
      stocksLesson.addBackActionListener(backButtonListener);
      marketLesson = new MarketLesson();
      marketLesson.addNextActionListener(nextButtonListener);
      marketLesson.addBackActionListener(backButtonListener);
      riskLesson = new RiskLesson();
      riskLesson.addNextActionListener(nextButtonListener);
      riskLesson.addBackActionListener(backButtonListener);
      simulatorStart = new SimulatorStart();
      simulatorStart.addNextActionListener(nextButtonListener);
      simulatorStart.addgoBackActionListener(goToIntroScreenListener);
      //simulatorStart.addBackActionListener(backButtonListener);
      
      
      //Add class objects to JApplet
      add(introScreen, introScreen.getName());
      add(moneyLesson, moneyLesson.getName());
      add(savingLesson, savingLesson.getName());
      add(interestLesson, interestLesson.getName());
      add(stocksLesson, stocksLesson.getName());
      add(marketLesson, marketLesson.getName());
      add(riskLesson, riskLesson.getName());
      add(simulatorStart, simulatorStart.getName());
      
      
      
      //ADD SIMULATION VIEWS
      
      //Simulation View
      simulation = new Simulation();
      simulation.addDoneActionListener(simDoneButtonListener);
      simulation.addRestartActionListener(goToIntroScreenListener);
      simulation.addToysInfoListener(simToysInfoButtonListener);
      simulation.addCandyInfoListener(simCandyInfoButtonListener);
      simulation.addPetInfoListener(simPetInfoButtonListener);
      simulation.addStarListener(simAddStarButtonListener);
      simulation.addEndListener(simEndButtonListener);

      
      add(simulation, simulation.getName());
      
      //Simulation Explanation View
      simExplanation = new SimulationExplanation();
      simExplanation.addBackActionListener(simExBackButtonListener);
      add(simExplanation, simExplanation.getName());
     
      //ADD SIMULATION MODELS
      simCalculator = new SimulationCalculator();
      
      //ADD SIMLUATION CONTROLLER
      simController = new SimulationController(simulation, simExplanation,simCalculator );
   }
   
   public void makeListeners(){
	   nextButtonListener = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	            cardlayout.next(getContentPane());
	         }
	      };
	      
	      backButtonListener = new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent arg0) {
	             cardlayout.previous(getContentPane());
	          }
	       };
	       
	       goToIntroScreenListener = new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent arg0) {
	               cardlayout.show(getContentPane(), "INTRO SCREEN");
	           }
	        };
	        
	        goToGameStartListener = new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	            	introScreen.changeButtonText();
	                cardlayout.show(getContentPane(), "INVEST START");
	            }
	         };
	      
	      simDoneButtonListener = new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent arg0) {
	        	simExplanation.generateResults();
	        	simExplanation.graph.addPoint(simulation.controller.changeInBalance);

	        	
	            cardlayout.show(getContentPane(), "EXPLANATION");
	            
	          }
	       };
	       
	       simResetButtonListener = new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent arg0) {
	        	   simulation.clearAll();
	           }
	        };
	       
	       simExBackButtonListener = new ActionListener() {
	           @Override
	           public void actionPerformed(ActionEvent arg0) {
	        	   simulation.advanceCycle();
	        	   
	        	   if(simController.Balance <= 0)
	        	   {
	        		   endGame();
	        	   }
	        	   else if(simController.year == 6)
	        	   {
	        		   cardlayout.show(getContentPane(), "SIMULATION");
	        		   simulation.lastChance();
	        		   
	        		   //endGame();
	        	   }
	        	   else
	        	   {
	        		   cardlayout.show(getContentPane(), "SIMULATION");
	        	   }
	               
	              
	           }
	        };
	        
	        simCandyInfoButtonListener = new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	         	   simulation.displayCandyInfo(simulation.controller.CandyCorpDescription);
	            }
	         };
	        
	         simToysInfoButtonListener = new ActionListener() {
	        	 @Override
	        	 public void actionPerformed(ActionEvent arg0) {
	        		 simulation.displayToysInfo(simulation.controller.ToysIncDescription);
	        	 }
	         };

	         simPetInfoButtonListener = new ActionListener() {
	        	 @Override
	        	 public void actionPerformed(ActionEvent arg0) {
	        		 simulation.displayPetInfo(simulation.controller.PetCoDescription);
	        	 }
	         };
	         
	         simAddStarButtonListener = new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent arg0){
	        		String starPrice = "20";

	        		boolean check = simController.balanceErrorCheck(starPrice);

	        		if(!check)
	        		{
	        			simulation.displayError("Insufficient funds");
	        		}
	        		else
	        		{
	        			simulation.addStuff();				
	        		}   		
	        		
	        		if(!(simController.gameStatus))
	        		{
	        			endGame();
	        		}
	        	}
	         };
	         
	         simEndButtonListener = new ActionListener(){
	        	 @Override
	        	 public void actionPerformed(ActionEvent arg0){
	        		 endGame();
	        		 
	        	 }
	         };
   }
   
   public void endGame()
   {
	   ConclusionPage conclusion;
	   conclusion = new ConclusionPage();
	   
	   add(conclusion, conclusion.getName());
	   cardlayout.show(getContentPane(), conclusion.getName());
   }
}