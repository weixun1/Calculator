/**
 * Assignment 3: Exception handling <br />
 * Calculator using BNF
 */

import java.util.Stack;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
public class Calculator {

    /**
     * Execute the expression, and return the correct value
     * @param exp           {@code String} The expression string
     * @return              {@code int}    The value of the expression
     */
	
	public static int calculateStack(Stack<String> operand,Stack<String> operator, ArrayList<String> varValue, ArrayList<String> varName, int exceptionFlag)
	{
		String op1 = operand.pop();
		String op2 = operand.pop();
		String op3 = operator.pop();
	
		
		if(op3.charAt(0) == '+')
		{
			if(Character.isLetter(op1.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op1.charAt(0) == varName.get(i).charAt(0))
					{
						op1 = varValue.get(i);
					}
				}
				if(Character.isLetter(op1.charAt(0)))
				{
					return 6;// undefined variable
				}
			}
			
			
			if(Character.isLetter(op2.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op2.charAt(0) == varName.get(i).charAt(0))
					{
						op2 = varValue.get(i);
					}
				}
			}
			
			if(Character.isLetter(op1.charAt(0))|Character.isLetter(op1.charAt(0)))
			{
				return 2; // unassigned variable, equal sign missing
			}
			int temp1 = Integer.parseInt(op1);

			int temp2 = Integer.parseInt(op2);
			int tempResult = temp1 + temp2;
			String resultString = Integer.toString(tempResult);

			operand.push(resultString);
		}
		else if(op3.charAt(0) == '-')
		{
			if(Character.isLetter(op1.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op1.charAt(0) == varName.get(i).charAt(0))
					{
						op1 = varValue.get(i);
					}
				}
			}
			
			
			if(Character.isLetter(op2.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op2.charAt(0) == varName.get(i).charAt(0))
					{
						op2 = varValue.get(i);
					}
				}
			}
			

			int temp1 = Integer.parseInt(op1);

			int temp2 = Integer.parseInt(op2);
			int tempResult = temp2 - temp1;
			String resultString = Integer.toString(tempResult);

			operand.push(resultString);
		}
		else if(op3.charAt(0) == '*')
		{
			if(Character.isLetter(op1.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op1.charAt(0) == varName.get(i).charAt(0))
					{
						op1 = varValue.get(i);
					}
				}
			}
			
			
			if(Character.isLetter(op2.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op2.charAt(0) == varName.get(i).charAt(0))
					{
						op2 = varValue.get(i);
					}
				}
			}
			

			int temp1 = Integer.parseInt(op1);

			int temp2 = Integer.parseInt(op2);
			int tempResult = temp1 * temp2;
			String resultString = Integer.toString(tempResult);

			operand.push(resultString);
		}
		else if(op3.charAt(0) == '/')
		{
			if(Character.isLetter(op1.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op1.charAt(0) == varName.get(i).charAt(0))
					{
						op1 = varValue.get(i);
					}
				}
			}
			
			
			if(Character.isLetter(op2.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op2.charAt(0) == varName.get(i).charAt(0))
					{
						op2 = varValue.get(i);
					}
				}
			}
			

			int temp1 = Integer.parseInt(op1);

			int temp2 = Integer.parseInt(op2);
			int tempResult = temp2 / temp1;
			String resultString = Integer.toString(tempResult);

			operand.push(resultString);
		}
		else if(op3.charAt(0) == '^')
		{
			if(Character.isLetter(op1.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op1.charAt(0) == varName.get(i).charAt(0))
					{
						op1 = varValue.get(i);
					}
				}
			}
			
			
			if(Character.isLetter(op2.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op2.charAt(0) == varName.get(i).charAt(0))
					{
						op2 = varValue.get(i);
					}
				}
			}
			

			double temp1 = Double.parseDouble(op1);

			double temp2 = Double.parseDouble(op2);
			
			double tempResult = Math.pow(temp2, temp1);
			int intResult = (int) tempResult;
			String resultString = Integer.toString(intResult);

			operand.push(resultString);
		}
		else if(op3.charAt(0) == '=')
		{
			int flag  = 0;
			
			if(Character.isLetter(op1.charAt(0)))
			{
				for(int i = 0; i < varName.size(); i++)
				{
					if(op1.charAt(0) == varName.get(i).charAt(0))
					{
						op1 = varValue.get(i);
					}
				}
			}

			for(int i = 0; i < varName.size(); i++)
			{
				if(op2.charAt(0) == varName.get(i).charAt(0))
				{
					varValue.set(i,op1); 
					operand.push(op1);
					flag = 1;
				}
			}
			
			if(!Character.isLetter(op1.charAt(0)) && !Character.isLetter(op2.charAt(0)))
			{
				return 4;// missing ), but more than that, also missing operators
			}
			if (flag == 0)
			{
				varName.add(op2);
				varValue.add(op1);
				operand.push(op1);
			}

		}
		else if(op3.charAt(0) == '(')
		{
			return 1; // 1 for unclosed bracket
		}
		return 0;
	}
	/*
	public static int evaluteExp(String exp)
	{
		Stack<String> operand = new Stack<>();
		Stack<String> operator = new Stack<>();
		
		String temp = exp.replaceAll("let", "");
		temp = temp.replaceAll(";","");
		temp = temp.trim();
		temp = temp.replaceAll(" ","");
		String[] temp1 = temp.split("");
		ArrayList<String> varValue = new ArrayList<String>();
		ArrayList<String> varName = new ArrayList<String>();
		// iterate through the char array

		for(String ele:temp1)
		{
			if(ele.charAt(0) == ' ')
			{
				continue;
			}
			else if(ele.charAt(0) == '+' || ele.charAt(0) == '-')
			{
				while(!operator.isEmpty() && (operator.peek().charAt(0) == '+' || operator.peek().charAt(0) == '-' || operator.peek().charAt(0) == '*' || operator.peek().charAt(0) == '/' || operator.peek().charAt(0) == '^'))
				{
					calculateStack(operand,operator,varValue,varName);
				}
				operator.push(ele);
			}
			else if(ele.charAt(0) == '*' || ele.charAt(0) == '/')
			{
				while(!operator.isEmpty() && (operator.peek().charAt(0) == '*' || operator.peek().charAt(0) == '/'))
				{
					calculateStack(operand,operator,varValue,varName);
				}
				operator.push(ele);
			}
			else if(ele.charAt(0) == '^')
			{
				while(!operator.isEmpty() && operator.peek().charAt(0) == '^') 
				{
					calculateStack(operand,operator,varValue,varName);
				}
				operator.push(ele);
			}
			else if(ele.charAt(0) == '(')
			{
				operator.push(ele);
			}
			else if(ele.charAt(0) == ')')
			{
				while(operator.peek().charAt(0) != '(')
				{
					calculateStack(operand,operator,varValue,varName);
				}
				operator.pop();
			}
			else if(ele.charAt(0) == '=')
			{
				operator.push(ele);
			}
			else if(Character.isLetter(ele.charAt(0)))
			{
				operand.push(ele);
			}
			else
			{
				operand.push(ele);
			}
		}
		
		while(!operator.isEmpty())
		{
			calculateStack(operand,operator,varValue,varName);
		}

		String ansInStr = operand.pop();
		int result = Integer.parseInt(ansInStr);
		return result;
	}
	*/
    public int execExpression(String exp) throws SyntaxErrorException,RuntimeErrorException{
        int returnValue = -1;
        // TODO: Assignment 3 Part 1 -- parse, calculate the expression, and return the correct value
        //returnValue = evaluteExp(exp);
        
        int exceptionFlag = 0;
        Stack<String> operand = new Stack<>();
		Stack<String> operator = new Stack<>();
		
		

		
		
		
		
		String temp = exp.replaceAll("let", "");
		
		Pattern regex = Pattern.compile("\\w{3}");
		Matcher match = regex.matcher(temp);
		
		while(match.find())
		{
			if(match.group().length() != 0)
			{
				if(match.group() != "let")
				{
					exceptionFlag = 5;//run time error, undefined variables
				}
			}
		}
		
		
		temp = temp.replaceAll(";","");
		temp = temp.trim();
		temp = temp.replaceAll(" ","");
		String[] temp1 = temp.split("");
		ArrayList<String> varValue = new ArrayList<String>();
		ArrayList<String> varName = new ArrayList<String>();
		// iterate through the char array

		for(String ele:temp1)
		{
			if(exceptionFlag != 0)
			{
				break;
			}
			if(ele.charAt(0) == ' ')
			{
				continue;
			}
			else if(ele.charAt(0) == '+' || ele.charAt(0) == '-')
			{
				while(!operator.isEmpty() && (operator.peek().charAt(0) == '+' || operator.peek().charAt(0) == '-' || operator.peek().charAt(0) == '*' || operator.peek().charAt(0) == '/' || operator.peek().charAt(0) == '^'))
				{
					calculateStack(operand,operator,varValue,varName,exceptionFlag);
				}
				operator.push(ele);
			}
			else if(ele.charAt(0) == '*' || ele.charAt(0) == '/')
			{
				while(!operator.isEmpty() && (operator.peek().charAt(0) == '*' || operator.peek().charAt(0) == '/'))
				{
					calculateStack(operand,operator,varValue,varName,exceptionFlag);
				}
				operator.push(ele);
			}
			else if(ele.charAt(0) == '^')
			{
				while(!operator.isEmpty() && operator.peek().charAt(0) == '^') 
				{
					calculateStack(operand,operator,varValue,varName,exceptionFlag);
				}
				operator.push(ele);
			}
			else if(ele.charAt(0) == '(')
			{
				operator.push(ele);
			}
			else if(ele.charAt(0) == ')')
			{
				exceptionFlag = 2; // guess work, this indicates that brackets have been entered,but no calculation is done, which is not possible for our grammar
				
				while(operator.peek().charAt(0) != '(')
				{
					exceptionFlag = calculateStack(operand,operator,varValue,varName,exceptionFlag);
					if(exceptionFlag != 0)
					{
						break;
					}
				}
				operator.pop();


			}
			else if(ele.charAt(0) == '=')
			{
				operator.push(ele);
			}
			else if(Character.isLetter(ele.charAt(0)))
			{
				operand.push(ele);
			}
			else
			{
				operand.push(ele);
			}
		}
		
		while(!operator.isEmpty())
		{
			exceptionFlag = calculateStack(operand,operator,varValue,varName,exceptionFlag);
			if(exceptionFlag != 0) 
			{
				break;
			}
		}


		

        // TODO: Assignment 3 Part 2-1 -- when come to illegal expressions, raise proper exceptions

		
		
		try
		{

			
			

			if(exceptionFlag == 5)
			{
				throw new RuntimeErrorException("Runtime Error: illegal initialization of a variable");
			}
			else if(exceptionFlag == 6)
			{
				throw new RuntimeErrorException("Runtime Error: undefined variable");
			}
			
			if(exceptionFlag == 1)
			{
				throw new SyntaxErrorException("Syntax error: ) expected");
			}
			else if(exceptionFlag == 2)
			{
				throw new SyntaxErrorException("Syntax Error: = expectec");
			}
			if(operator.isEmpty() && !operand.isEmpty())
			{
				String check = operand.pop();
				if(operator.isEmpty() && !operand.isEmpty())
				{
					exceptionFlag = 3; // missing operator
					throw new SyntaxErrorException("SyntaxError: operator expected");
				}
				operand.push(check);
			}
			if(exceptionFlag == 4)
			{
				throw new SyntaxErrorException("Syntax Error: ) expected, and possible missing operators");
			}
			if(exceptionFlag == 0)
			{
				String ansInStr = operand.pop();
				int result = Integer.parseInt(ansInStr);
				return result;
			}



		}finally
		{

		}
		
		
		
		return returnValue;


    }

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) throws SyntaxErrorException,RuntimeErrorException{
        Calculator calc = new Calculator();
        // Part 1
        String[] inputs = {
        	
            "let x = 1;",                                                                           // 1, returns 1
            "(let x = 1) + x;",                                                                     // 2, returns 2
            "(let a = 2) + 3 * a - 5;",                                                             // 3, returns 3
            "(let x = (let y = (let z = 1))) + x + y + z;",                                         // 4, returns 4
            "1 + (let x = 1) + (let y = 2) + (1 + x) * (1 + y) - (let x = y) - (let y = 1) - x;",   // 5, returns 5
            "1 + (let a = (let b = 1) + b) + a + 1;",                                               // 6, returns 6
            "(let a = (let a = (let a = (let a = 2) + a) + a) + a) - 9;",                           // 7, returns 7
            "(let x = 2) ^ (let y = 3);",                                                           // 8, returns 8
            "(let y = 3) ^ (let x = 2);"                                                            // 9, returns 9
        };
        for (int i = 0; i < inputs.length; i++)
            System.out.println(String.format("%d -- %-90s %d", i+1, inputs[i], calc.execExpression(inputs[i])));

        // Part 2
        inputs = new String[] {
                "1 + (2 * 3;",                  // 1, syntax error: ')' expected
                "(let x 5) + x;",               // 2, syntax error: '=' expected
                "(let x = 5) (let y = 6);",     // 3, syntax error: operator expected
                "(let x = 5 let y = 6);",       // 4, syntax error: ')' expected
                "(ler x = 5) ^ (let y = 6);",   // 5, runtime error: 'ler' undefined
                "(let x = 5) + y;"              // 6, runtime error: 'y' undefined
                
        };
        // TODO: Assignment 3 Part 2-2 -- catch and deal with your exceptions here
        for (int i = 0; i < inputs.length; i++)
        {
        	try
        	{
        		System.out.println(String.format("%d -- %-30s %d", i+1, inputs[i], calc.execExpression(inputs[i])));
        	}
        	catch(RuntimeErrorException|SyntaxErrorException e)
    		{
    			System.out.println(e);
    		}
        }
    }

}

