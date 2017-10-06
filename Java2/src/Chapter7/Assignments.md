# Assignments Index
Assignments for this week:
 - 7.1 to 7.34

# Assignment Solutions
 - **Exercise 7.1 Add several comments to the sales item while keeping an eye on the inspector 
   for the comments list. Make sure the list behaves as expected (that is, its size should increase). 
   You may also like to inspect the elementData field of the ArrayList object.**
   - Nope it doesn't increase. see [SalesClass](OnlineShopJunit/SalesItem.java)
   
 - **Exercise 7.2 Check that the showInfo method correctly prints the item information, including the comments. 
    Try this both for items with and without comments.**
    - Done see: [The test method](OnlineShopJunit/SalesItemTest.java)
    
 - **Exercise 7.3 Check that the getNumberOfComments method works as expected**
    - Done see: [The test method](OnlineShopJunit/SalesItemTest.java)
  
 - **Exercise  7.4 Now check that duplicate authors are correctly handled—i.e., that further comments by the same author  
    are rejected. When trying to add a comment with an author name for whom a comment already exists, the addComment method  
    should  return false**
    . - Yes, Done see: [The test method](OnlineShopJunit/SalesItemTest.java)
    
 - **Exercise 7.5 Perform boundary checking on the rating value. That is, create comments not 
     only with medium ratings, but also with top and bottom ratings. Does this work correctly?**
     - No, Done see: [The test method](OnlineShopJunit/SalesItemTest.java)
     
 - **Exercise 7.6 Good boundary testing also involves testing values that lie just beyond the valid 
     range of data. Test 0 and 6 as rating values. In both cases, the comment should be rejected  
     ( addComment should return false, and the comment should not be added to the comment list).**
     - No, fixed see: [The sales item](OnlineShopJunit/SalesItem.java)
     
 - **Exercise  7.7 Test the upvoteComment and downvoteComment methods. Make sure that the vote balance is correctly counted.**
     - Yes, see: [The sales Test](OnlineShopJunit/SalesItemTest.java)
     
 - **Exercise 7.8 Use the  upvoteComment and downvoteComment methods to mark some comments  as  more  or  less  helpful.  
    Then  test  the findMostHelpfulComment method. This method should return the comment that was voted most helpful. 
    You will notice that the method  returns  an  object  reference.  You  can  use  the Inspect function  in  the  
    method  result dialog to check whether the correct comment was returned. Of course, you will need to know 
     which is the correct comment in order to check whether you get the right result!**
     - Yes, see: [The sales Test](OnlineShopJunit/SalesItemTest.java)
     
 - **Exercise 7.9 Do boundary testing of the findMostHelpfulComment method. That is, call this method when the comments 
    list is empty (no comments have been added). Does this work as expected?**
    - Nope you get an NoSuchElementException, see: [The sales Test](OnlineShopJunit/SalesItemTest.java) 
    
 - **Exercise 7.10 The tests in the exercises above should have uncovered two bugs in our  
     code. Fix them. After fixing these errors, is it safe to assume that all previous tests will still work 
     as before? Section 7.4 will discuss some of the testing issues that arise when software is cor-
     rected or enhanced.**
     - Yes, that is the meaning of automated testing.
     
 - **Exercise 7.11 Which of the test cases mentioned in the previous exercises are positive tests and which are negative? 
    Make a table of each category. Can you think of further positive tests? Can you think of further negative ones?**
    
 
 - **Exercise 7.12 Run the tests in your project, using the Run Tests button. You should see a window similar to 
    Figure 7.4, summarizing the results of the tests.**
    - Done.
 
 - **Exercise 7.13 Create a test class for the Comment class in the online-shop-junit project.**
   - Done see [CommentTest](OnlineShopJunit/CommentTest.java) 
   
 - **Exercise 7.14 What methods are created automatically when a new test class is created?**
   - None when using Inteliij IDEA
   
 - **Exercise 7.15 Create a test to check that addComment returns false when a comment from the same author already exists.**
   - Done see: [SalesItemTest](OnlineShopJunit/SalesItemTest.java)
   
 - **Exercise 7.16 Create a test that performs negative testing on the boundaries of the rating range. That is, test 
    the values 0 and 6 as a rating (the values just outside the legal range). We expect these to return false , so 
    assert false in the result dialog. You will notice that one of these actually (incorrectly) returns true . 
    This is the bug we uncovered earlier in manual test- ing. Make sure that you assert false anyway. The assertion 
    states the expected result, not the actual result.**
   - Done see: [SalesItemTest](OnlineShopJunit/SalesItemTest.java)
   
 - **Exercise 7.17 Run all tests again. Explore how the Test Result dialog displays the failed test. Select the failed 
    test in the list. What options do you have available to explore the details of the failed test?**
    - You can see what tests failed and on what line.
    
 - **Exercise 7.18 Create a test class that has Comment as its reference class. Create a test that checks whether the 
     author and rating details are stored correctly after creation. Record separate tests that check whether the upvote 
     and downvote methods work as expected.**
     - Done see: [CommentTest](OnlineShopJunit/CommentTest.java)
 
 - **Exercise 7.19 Create tests for SalesItem that test whether the findMostHelpfulCom- ment method works as expected. 
     Note that this method returns a Comment object. During your testing, you can use the Get button in the method result 
     dialog to get the result object onto the object bench, which then allows you to make further method calls and add 
     assertions for this object. This allows you to identify the comment object returned (e.g., by checking its author). 
     You can also assert that the result is null or not null , depending on what you expect.**
     - Done see: [SalesItemTest](OnlineShopJunit/SalesItemTest.java)
     
 - **Exercise 7.20 Add further automated tests to your project until you reach a point where you are reasonably 
     confident of the correct operation of the classes. Use both positive and nega- tive tests. If you discover any errors, 
     be sure to record tests that guard against recurrence of these errors in later versions.**
    - Done see: [SalesItemTest](OnlineShopJunit/SalesItemTest.java)
    
 - **Exercise 7.21 Make sure the classes in the project are compiled, and then create a CalcEngineTester object within 
    BlueJ. Call the testAll method. What is printed in the terminal window? Do you believe the final line of what it says?**
    - No because it will always print it.
    
 - **Exercise 7.22 Using the object you created in the previous exercise, call the testPlus method. What result does it 
     give? Is that the same result as was printed by the call to tes- tAll ? Call testPlus one more time. What result does
     it give now? Should it always give the same answer? If so, what should that answer be? Take a look at the source of 
     the testPlus method to check.**
    - It returns 7. 
    - Still 7 because it clears the last inputs. 
    - See  [CalculatorPrint](CalculatorPrint/CalcEngineTester.java)
    
 - **Exercise 7.23 Repeat the previous exercise with the testMinus method. Does it always give the same result?**
    - Nope, if you call it 2 times it will not clear and apply it 2 times.
    
 - **Exercise 7.24 Perform a similar walkthrough of your own with the testMinus method. Does that raise any further 
    questions in your mind about things you might like to check when looking at CalcEngine in detail?**
     - Yes I fixed it in [CalculatorPrint](CalculatorPrint/CalcEngine.java)
     - Yes add an test clear [CalculatorEngineTest::assignment724ClearTest](CalculatorPrint/CalcEngineTester.java)
 
 - **Exercise 7.25 Complete the state table based on the following subsequent calls found in the testPlus 
    method: numberPressed(4); equals(); getDisplayValue();**
    - The state table
    | **Method called** | **displayValue**  |**leftOperand**| **previousOperator**  |
    |:------------------|:------------------|:--------------|:----------------------|
    | _initial state_   | 0                 |             0 |                    ' '|
    | _clear()_         | 0                 |             0 |                    ' '|
    | _numberPressed(3)_| 3                 |             0 |                    ' '|
    | _plus()_          | 0                 |             3 |                    '+'|
    | _numberPressed(4)_| 4                 |             3 |                    '+'|
    | _equals()_        | 7                 |             0 |                    '+'|
    |_getDisplayValue()_| 7                 |             0 |                    '+'|
  
 - **Exercise 7.26 When walking through the equals method, did you feel the same reassurances that we felt in 
    applyPreviousOperator about the default value of previousOperator ?**
    - No, no because it should reset it after equals is called.
    
 - **Exercise 7.27 Walk through a call to clear immediately following the call to getDisplayValue at the end of your 
    state table, and record the new state. Is the engine in the same state as it was at the previous call to clear ? 
    If not, what impact do you think this could have on any subsequent calculations?**
    - If you don't reset the `previousOperator` after an equals call you will automaticly perform the previous operation
      with the last result (that's the `displayValue`) and the newly inputted number so if you do 9 + 1 = 10 and then
      call `numberPressed(5)` the calculator will add 5 to 10.
    
    
 - **Exercise 7.28 In the light of your walkthrough, what changes do you think should be made to the CalcEngine class? 
    Make those changes to a paper version of the class, and then try the walkthrough all over again. You should not 
    need to walk through the CalcEngineTester class, just repeat the actions of its testAll method.**
    - I already updated the calculator class see: [The CalculatorEngine Class](CalculatorPrint/CalcEngine.java)
    
 - **Exercise 7.29 Try a walkthrough of the following sequence of calls on your corrected version of the 
    engine: clear(); numberPressed(9); plus(); numberPressed(1); minus(); numberPressed(4); equals(); What 
    should the result be? Does the engine appear to behave correctly and leave the correct answer in displayValue ?**
    - Yes, but previously not.
    
 - **Exercise 7.30 Open the calculator-engine-print project and complete the addition of print statements to 
    each method and the constructor.**
    - Done, see: [The CalculatorEngine Class](CalculatorPrint/CalcEngine.java)
    
 - **Exercise 7.31 Create a CalcEngineTester in the project and run the testAll method. Does the output that results 
    help you identify where the problem lies?**
    - Yes you see that the state of the calculator is modified even after an clear. Maybe try [functional programming](https://vimeo.com/46276948)
    ![alt text](state.jpg "State meme")
    
 - **Exercise 7.32 Do you feel that the amount of output produced by the fully annotated CalcEngine class is too 
    little, too much, or about right? If you feel that it is too little or too much, either add further print 
    statements or remove some until you feel that you have the right level of detail.**
    - To much, this violates the single responsibility principle. You could use an logger but no method should do more 
    than one thing. If your method adds 2 numbers it should not spam the terminal. (unless you have an `printSumOff(x,y)` 
    method of course ). 
    
 - **Exercise 7.33 What are the respective advantages and disadvantages of using manual walkthroughs or print statements 
    for debugging? Discuss.**
    - Its really time consuming, and in the case of print statements just horrible. And if you change your code you 
    have to manually walk through everything again. If you use automated unit tests you will notice bugs when some part
    of your code is updated. Its also really handy when you integrate your unit tests with `CI` tools like travis so that 
    every push will automatically report code issues.
    
 - **Exercise 7.34 Using the calculator-engine project, set a breakpoint in the first line of the testPlus method in 
    the CalcEngineTester class. Execute this method. When the debugger appears, walk through the code step by step. 
    Experiment with both the Step and Step Into buttons.**
    - Done but with Intellij IDEA. 