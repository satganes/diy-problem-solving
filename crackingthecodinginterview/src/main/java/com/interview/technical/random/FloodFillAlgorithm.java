package com.interview.technical.random;

import java.util.Arrays;

import javax.security.auth.login.FailedLoginException;

/**
 * In MS-Paint, when we take the brush to a pixel and click, the color of the
 * region of that pixel is replaced with a new selected color. Following is the
 * problem statement to do this task. Given a 2D screen, location of a pixel in
 * the screen and a color, replace color of the given pixel and all adjacent
 * same colored pixels with the given color.
 * 
 * 
 * <pre>
 * Input:
 *     screen[M][N] = {
 *                    {1, 1, 1, 1, 1, 1, 1, 1},
 *                    {1, 1, 1, 1, 1, 1, 0, 0},
 *                    {1, 0, 0, 1, 1, 0, 1, 1},
 *                    {1, 2, 2, 2, 2, 0, 1, 0},
 *                    {1, 1, 1, 2, 2, 0, 1, 0},
 *                    {1, 1, 1, 2, 2, 2, 2, 0},
 *                    {1, 1, 1, 1, 1, 2, 1, 1},
 *                    {1, 1, 1, 1, 1, 2, 2, 1},
 *                    };
 *  x = 4, y = 4, newColor = 3
 *  The values in the given 2D screen indicate colors of the pixels.
 *  x and y are coordinates of the brush, newColor is the color that
 *  should replace the previous color on screen[x][y] and all surrounding
 *  pixels with same color.
 * 
 *  Output:
 *  Screen should be changed to following.
 *     screen[M][N] = {
 *                    {1, 1, 1, 1, 1, 1, 1, 1},
 *                    {1, 1, 1, 1, 1, 1, 0, 0},
 *                    {1, 0, 0, 1, 1, 0, 1, 1},
 *                    {1, 3, 3, 3, 3, 0, 1, 0},
 *                    {1, 1, 1, 3, 3, 0, 1, 0},
 *                    {1, 1, 1, 3, 3, 3, 3, 0},
 *                    {1, 1, 1, 1, 1, 3, 1, 1},
 *                    {1, 1, 1, 1, 1, 3, 3, 1},
 *                    };
 * 
 * </pre>
 * 
 * @author Sathish Ganesan
 *
 */
public class FloodFillAlgorithm
{
    public static void fill(int[][] input, int x, int y, int prev, int replace)
    {
        if ((x >= 0 && y >= 0 && x < input.length && y < input[0].length))
        {
            if (input[x][y] == prev)
            {
                input[x][y] = replace;
                fill(input, x + 1, y, prev, replace);
                fill(input, x - 1, y, prev, replace);
                fill(input, x, y + 1, prev, replace);
                fill(input, x, y - 1, prev, replace);
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] input = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 1, 1 }, { 1, 3, 3, 3, 3, 0, 1, 0 }, { 1, 1, 1, 3, 3, 0, 1, 0 },
                { 1, 1, 1, 3, 3, 3, 3, 0 }, { 1, 1, 1, 1, 1, 3, 1, 1 }, { 1, 1, 1, 1, 1, 3, 3, 1 }, };
        FloodFillAlgorithm.fill(input, 4, 4, 3, 5);
        for (int i = 0; i < input.length; i++)
        {
            for (int j = 0; j < input[i].length; j++)
            {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

}
