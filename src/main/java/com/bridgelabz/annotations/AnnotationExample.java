package com.bridgelabz.annotations;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
public class AnnotationExample 
{

	@Override
	@MethodInfo(author="abc",comments="main method",date="sep 21 2020",revision=1)
	public String toString()
	{

		return "Overridden tostring method";
	}

	public static void main(String[] args) 
	{


		try 
		{
			for(Method method:AnnotationExample.class.getMethods())
			{
				if(method.isAnnotationPresent(MethodInfo.class)) 
				{

					try
					{
						for(Annotation anno:method.getDeclaredAnnotations())
						{
							System.out.println("Annotation in method "+method+" "+anno);
						}
						MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);

						if(methodAnno.revision()==1)
						{
							System.out.println("Method with revisoon number 1="+method);
						}
					}
					catch (Throwable e) 
					{

						e.printStackTrace();
					}
				}
			}

		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
	}
}
