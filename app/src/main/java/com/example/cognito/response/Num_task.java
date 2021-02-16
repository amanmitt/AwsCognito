package com.example.cognito.response;

public class Num_task
{
    private String N;

    public String getN ()
    {
        return N;
    }

    public void setN (String N)
    {
        this.N = N;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [N = "+N+"]";
    }
}
