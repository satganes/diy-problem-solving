package com.interview.technical.codility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionIter implements Iterable<Integer>
{

    private Reader reader;

    public SolutionIter(Reader inp)
    {
        reader = inp;

    };

    public Iterator<Integer> iterator()
    {

        return new CustomIterator();
    }

    public static void main(String[] args)
    {
        StringBuilder builder = new StringBuilder();

        BufferedReader bufferedReader = null;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(
                    "D:\\sathish\\ws\\diy-problem-solving\\crackingthecodinginterview\\src\\main\\java\\com\\interview\\technical\\codility\\inputFile"));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String line;
        try
        {
            while ((line = bufferedReader.readLine()) != null)
            {
                builder.append(line).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Reader reader = new StringReader(builder.toString());

        for (Integer arg : new SolutionIter(reader))
        {
            System.out.println("arg is:" + arg);

        }
    }

    private class CustomIterator implements Iterator<Integer>
    {
        private int cursor;

        public CustomIterator()
        {
        }

        public boolean hasNext()
        {
            try
            {
                cursor = reader.read();

                return -1 != cursor;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return false;
        }

        public Integer next()
        {
            StringBuilder builder = new StringBuilder();

            try
            {
                while (cursor != 10 && cursor != -1)
                {
                    builder.append((char) cursor);
                    cursor = reader.read();
                }
                Pattern p = Pattern.compile("^( )\\\\d+( )$");
                Matcher m = p.matcher(builder);
                m.replaceAll("");
                
                String out = builder.toString().trim();
                // Regex to parse float ^\\d+$

                Integer output = Integer.parseInt(out);
                return output;

            }
            catch (Exception e)
            {

                try
                {
                    cursor = reader.read();
                }
                catch (IOException exception)
                {
                    exception.printStackTrace();
                }
                return next();
            }
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
