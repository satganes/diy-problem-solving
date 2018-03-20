package com.interview.technical.random;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DateOverlap
{

    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2)
    {
        return start1.before(end2) && start2.before(end1);
    }

    public static Boolean canViewAll(Collection<Movie> movies)
    {
        for (Movie m : movies)
        {
            for (Movie j : movies)
            {
                if (m != j && isOverlapping(m.getStart(), m.getEnd(), j.getStart(), j.getEnd()))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:31"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        System.out.println(DateOverlap.canViewAll(movies));
    }

}

class Movie
{
    private Date start, end;

    public Movie(Date start, Date end)
    {
        this.start = start;
        this.end = end;
    }

    public Date getStart()
    {
        return this.start;
    }

    public Date getEnd()
    {
        return this.end;
    }
}
