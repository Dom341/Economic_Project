import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.*;
 

public class SimulationLaunch extends JPanel {
	
	//Simulation launcher
	   private SimulatorStart simulatorStart;
	   
	   //Simulation Views
	   private Simulation simulation;
	   private SimulationExplanation simExplanation;
	   
	   //Simulation Model
	   private SimulationCalculator simCalculator;
	   
	   //Simulation Controller
	   private SimulationController simController;
	   
	   //Set layout
	   private CardLayout cardlayout = new CardLayout();
	 
	   public SimulationLaunch()
	   {
		   init();
	   }
	   
	   //Create game
	   public void init() {
	      setLayout(cardlayout);
	      setSize(1000, 600);
	      
	      ActionListener buttonListener = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	            cardlayout.next(getRootPane());
	         }
	      };
	 
	      simulatorStart = new SimulatorStart();
	      simulatorStart.addNextActionListener(buttonListener);
	 
	      
	      add(simulatorStart, simulatorStart.getName());
	      
	      
	      //ADD SIMULATION VIEWS
	      
	      //Simulation View
	      simulation = new Simulation();
	      simulation.addDoneActionListener(buttonListener);
	      add(simulation, simulation.getName());
	      
	      //Simulation Explanation View
	      simExplanation = new SimulationExplanation();
	      simExplanation.addBackActionListener(buttonListener);
	      add(simExplanation, getName());
	     
	      //ADD SIMULATION MODELS
	      simCalculator = new SimulationCalculator();
	      
	      //ADD SIMLUATION CONTROLLER
	      simController = new SimulationController(simulation, simExplanation,simCalculator );
	   }
	   
}