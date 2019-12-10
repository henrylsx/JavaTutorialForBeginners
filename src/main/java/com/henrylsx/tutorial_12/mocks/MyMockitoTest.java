package com.henrylsx.tutorial_12.mocks;

//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

//credits: Baeldung


@RunWith(MockitoJUnitRunner.class)
public class MyMockitoTest {
	
	
	/*
	 * Dummy objects are passed around but never actually used. Usually, they are
	 * just used to fill parameter lists. 
	 * 
	 * Fake objects have working implementations,
	 * but usually, take some shortcut which makes them not suitable for production
	 * (an in memory database is a good example). 
	 * 
	 * Stubs provide canned answers to
	 * calls made during the test, usually not responding at all to anything outside
	 * what's programmed in for the test. Stubs may also record information about
	 * calls, such as an email gateway stub that remembers the messages it ‘sent',
	 * or maybe only how many messages it ‘sent'. 
	 * 
	 * Spies are stubs that also record
	 * some information based on how they were called. One form of this might be an
	 * email service that records how many messages it was sent. 
	 * 
	 * Mocks are objects
	 * pre-programmed with expectations which form a specification of the calls they
	 * are expected to receive.
	 */

	// use import static for mockito class to allow easier calls of the methods like
	// mock, verify etc and use MockitoJUnitRunner so that annotations will work
	
	//BDD - Behavior Driven Development
	//As a <user> I want <feature> so that <benefits> 
	//Given <initial context>, When <event>, Then <expected outcome>

	@Test
	public void testBasicMockito() {
		// mock creation
		@SuppressWarnings("unchecked")
		List<String> mockedList = mock(ArrayList.class);

		// using mock object, it allow any methods of the original object to be called
		mockedList.add("aString");
		mockedList.add("aString");
		mockedList.clear();

		//it records the method calls, which we can use "verify" to check the occurence
		verify(mockedList,times(2)).add("aString");
		verify(mockedList).clear();
		
		//we can mock certain method call return values using "when" - "thenReturn"
		when(mockedList.get(0)).thenReturn("first");
		assertEquals(mockedList.get(0),"first");
	}

	
	//Instead of using mock() we can use @Mock annotations
	@Mock List<String> mockedList;
	@Captor ArgumentCaptor<String> argCaptor;	//captures the argument being passed to the mocks
	@Test
	public void testMockitoMockAnnotation() {
		//test of mocks
		mockedList.add("one");
	    verify(mockedList).add("one");
	    assertEquals(0, mockedList.size()); 
	    when(mockedList.size()).thenReturn(100);
	    assertEquals(100, mockedList.size());
	    
	    mockedList.remove("one");
	    verify(mockedList).remove((String) argCaptor.capture());
	    assertEquals("one", argCaptor.getValue());
	    
	}
	
	
	//use spy to create the object that the behavior we can change later on
	@Spy List<String> spiedList = new ArrayList<String>();
	@Test
	public void testMockitoSpyAnnotation() {
	    spiedList.add("one");   //the original ArrayList add()
	    spiedList.add("two");
	    verify(spiedList).add("one");
	    verify(spiedList).add("two");
	    assertEquals(2, spiedList.size());	
	    doReturn(100).when(spiedList).size();	//modified behavior
	    assertEquals(100, spiedList.size());
	}
	
	@Mock Map<String, String> wordMap;
	@InjectMocks MyDictionary myDictionary = new MyDictionary();
	//similar to autowired in spring, it uses the mock to inject wordMap to myDictionary
	@Test(expected = NullPointerException.class)
	public void testInjectMocks() {
	    when(wordMap.get("aWord")).thenReturn("aMeaning");
	    assertEquals("aMeaning", myDictionary.getMeaning("aWord"));
	    
	    when(wordMap.get("nonExistentWord")).thenThrow(NullPointerException.class);
	    myDictionary.getMeaning("nonExistentWord");	//throw NPE
	}

}


class MyDictionary{
	Map<String, String> wordMap;
	 
    public MyDictionary() {
        wordMap = new HashMap<String, String>();
    }
    public void add(final String word, final String meaning) {
        wordMap.put(word, meaning);
    }
    public String getMeaning(final String word) {
        return wordMap.get(word);
    }
}