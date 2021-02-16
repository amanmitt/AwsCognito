package com.example.cognito.response;


public class BaseResponse
{
    private Num_task num_task;

    private Zoca_id zoca_id;

    private Campaign campaign;

    private Zone_name zone_name;

    private Brand brand;

    private Zone_username zone_username;

    private States states;

    public Num_task getNum_task ()
    {
        return num_task;
    }

    public void setNum_task (Num_task num_task)
    {
        this.num_task = num_task;
    }

    public Zoca_id getZoca_id ()
    {
        return zoca_id;
    }

    public void setZoca_id (Zoca_id zoca_id)
    {
        this.zoca_id = zoca_id;
    }

    public Campaign getCampaign ()
    {
        return campaign;
    }

    public void setCampaign (Campaign campaign)
    {
        this.campaign = campaign;
    }

    public Zone_name getZone_name ()
    {
        return zone_name;
    }

    public void setZone_name (Zone_name zone_name)
    {
        this.zone_name = zone_name;
    }

    public Brand getBrand ()
    {
        return brand;
    }

    public void setBrand (Brand brand)
    {
        this.brand = brand;
    }

    public Zone_username getZone_username ()
    {
        return zone_username;
    }

    public void setZone_username (Zone_username zone_username)
    {
        this.zone_username = zone_username;
    }

    public States getStates ()
    {
        return states;
    }

    public void setStates (States states)
    {
        this.states = states;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [num_task = "+num_task+", zoca_id = "+zoca_id+", campaign = "+campaign+", zone_name = "+zone_name+", brand = "+brand+", zone_username = "+zone_username+", states = "+states+"]";
    }
}

