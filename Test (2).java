package com.xtremesoftech.eims.lessonplanning.pdfgeneration;
import com.xtremesoftech.eims.lessonplanning.pdfgeneration.PdfGeneration;

import java.util.ArrayList;

import com.xtremesoftech.eims.lessonplanning.model.*;
public class Test {
	public static void main(String[] args) {
		
		LessonPlan lplan = new LessonPlan();
		LessonInfo info = lplan.getLessonInfo();
		info.setClassName("VIII");
		info.setSubject("English");
		info.setTeacher("Ankit Mishra");
		info.setTerm("Term1");
		info.setDurationFrom("Day 10");
		info.setDurationTo("Day 15");
		info.setTopic("Testing the PDF generation for Lesson Plan");
		info.setKeyVocabulary("k1, kv2, kv3 ");
		
		LessonOutcomes outcomes = lplan.getLessonOutcomes();
		
		ArrayList<LessonOutcome> outcome = new ArrayList<LessonOutcome>();
		LessonOutcome outcome1 = new LessonOutcome();
		outcome1.setDescription("This is outcome 1");
		outcome1.setAssesment("Manually check the first column has outcome 1 written in it");
		outcome.add(outcome1);
		
		LessonOutcome outcome2 = new LessonOutcome();
		outcome2.setDescription("This is outcome 2");
		outcome2.setAssesment("Manually check outcome 2 written in it");
		outcome.add(outcome2);
		
		LessonOutcome outcome3 = new LessonOutcome();
		outcome3.setDescription("This is outcome three");
		outcome3.setAssesment("Manually check written in it");
		outcome.add(outcome3);
		outcomes.setOutcomes(outcome);
		

		LessonAssignments lessonAssignments = lplan.getLessonAssignments();
		
		ArrayList<Assignment> lessonAssignment = new ArrayList<Assignment>();
		Assignment lessonAssignment1 = new Assignment();
		lessonAssignment1.setDay("Day 15");
		lessonAssignment1.setDescription("Physics Test 1");
		lessonAssignment.add(lessonAssignment1);
		
		Assignment lessonAssignment2 = new Assignment();
		lessonAssignment2.setDay("Day 16");
		lessonAssignment2.setDescription("Physics Test 2");
		lessonAssignment.add(lessonAssignment2);
		
		Assignment lessonAssignment3 = new Assignment();
		lessonAssignment3.setDay("Day 17");
		lessonAssignment3.setDescription("Physics Test 3");
		lessonAssignment.add(lessonAssignment3);
		lessonAssignments.setAssignments(lessonAssignment);
		
		
		LessonDetails lessonDetails = lplan.getLessonDetails();
		ArrayList<MainLearning> mainLearning = new ArrayList<MainLearning>();
		
		MainLearning learning1 = new MainLearning();
		learning1.setDay("day 1");
		learning1.setRecapDuration("5 min");
		learning1.setRecapStrategy("Strategy 1");
		learning1.setLearningDuration("10 min");
		learning1.setLearningStrategy("Revision And Memorization");
		mainLearning.add(learning1);
		
		MainLearning learning2 = new MainLearning();
		learning2.setDay("day 2");
		learning2.setRecapDuration("15 min");
		learning2.setRecapStrategy("Strategy 2");
		learning2.setLearningDuration("14 min");
		learning2.setLearningStrategy("Revision Only");
		mainLearning.add(learning2);
		
		MainLearning learning3 = new MainLearning();
		learning3.setDay("day 3");
		learning3.setRecapDuration("50 min");
		learning3.setRecapStrategy("Strategy 3");
		learning3.setLearningDuration("15 min");
		learning3.setLearningStrategy(" Memorization");
		mainLearning.add(learning3);
		
		lessonDetails.setLearnings(mainLearning);
		
		
		
		PdfGeneration pdfgen = new PdfGeneration();
		pdfgen.generatePdf(lplan);

	}
}
