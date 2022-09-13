# Katas Playground

I chose to have all my katas in the same repo using Trunk-Based development. They are independent exercises, and I find
it easier
to update this way. On top of that, I have one source of truth to go when I have doubts, or I have new ideas.
The weapon of choice is Java. 

## Key takeaways

- It can be useful to instead of using camelCase in the tests, to use snake case but separating the **given_when_then**
  subsections
  for quicker feedback loop
- I find **Starting Step Tests** interesting
- Commit more often to encourage good habits
- Even when assumed, I think it is good to remember the following when pair programming: 'It is not a personal
activity and all we put on the table are opinions of two different people to solve a problem. At the end of they day,
there are no stupid comments or questions just people who may or may not understand all the caveats of the problem. 
The key is to remember, that when pairing, we are not attacking each other but putting solutions on the table.'
- Not a fan of Hungarian Notation but I find using 'I' before the name of my interfaces useful. Only for this case, as it allows me 
to quickly identify if I am in front of an abstraction or its implementation.
- About Hungarian Notation, I believe there is room for it when needed:  https://www.joelonsoftware.com/2005/05/11/making-wrong-code-look-wrong/

## Log

- Rest of the katas are from the 'pre-Academy' era, so load of things need change even though the tests pass 
- Mars Rovers with State Pattern ( I am happy with this now)
- First Iteration Bank Kata Done
- NewBank is the name of the Bank Kata I did with Istvan as a collaborator. We had really nice discussions and learned 
a lot from each other. Thanks mate!
- I added Cucumber to play with it in the Bank Kata, it was fun to be honest
- Working on the first version of the infamous exercise 'Transverse a Binary Tree', I will keep iterating until I get something decent. So far I would love 
to make the code more readable, and avoid make the client casting everything when getting values and still leave the collection open for any type object.
I am going to work on the three types of transversal: In order, preorder traversal and postorder traversal.