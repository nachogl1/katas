The method can take 1 or 2 comma-separated numbers, and will return their sum.
Allow the Add method to handle an unknown amount of numbers.
Allow the Add method to recognise newlines as well as commas as separators. The two separator types can be used interchangeably.
NB: Focus on the happy path - since this is not production code, it's fine if the code crashes if it's given invalid input (e.g. "1,\n2").
Optionally support custom separators. To change separator, the beginning of the string will contain a separate line that looks like this: “//<separator>\n<numbers>”
Calling Add with a negative number will throw an exception negatives not allowed, and the negative that was passed.

If there are multiple negatives, show all of them in the exception message.
Numbers bigger than 1000 should be ignored.
Separators can be of any length if surrounded by square brackets.
Allow multiple single-character separators like this: “//[delim1][delim2]\n”
Handle multiple separators with any character length.