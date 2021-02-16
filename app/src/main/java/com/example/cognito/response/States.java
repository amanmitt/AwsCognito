package com.example.cognito.response;

public class States
{
    private String[] SS;

    public String[] getSS ()
    {
        return SS;
    }

    public void setSS (String[] SS)
    {
        this.SS = SS;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SS = "+SS+"]";
    }
}

