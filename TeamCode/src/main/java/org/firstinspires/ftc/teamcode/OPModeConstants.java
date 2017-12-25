package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.detectors.JewelDetector;

/**
 * Created by Akanksha.Joshi on 23-Dec-2017.
 */

public class OPModeConstants {
    private static OPModeConstants opModeConstants;
    public static double jewelArmActive = 0.52d;
    public static double jewelArmInactive = 0.00d;
    public static boolean JewelDetectionDisabled = false;
    private OPModeConstants()
    {
        setFireSequence(FireSequence.UNKNOWN);
        setSelectedTeam(SelectedTeam.UNKNOWN);
        setDetectedOrder(JewelDetector.JewelOrder.UNKNOWN);
        jewelArmActive = 0.52d;
        jewelArmInactive = 0.00d;
        JewelDetectionDisabled = false;
    }
    public static OPModeConstants getInstance()
    {
        if(opModeConstants==null)
        {
            opModeConstants = new OPModeConstants();
        }
        return opModeConstants;
    }

    public enum SelectedTeam
    {
        RED_TEAM,
        BLUE_TEAM,
        UNKNOWN
    }
    public enum FireSequence
    {
        FORWARD,
        BACKWARD,
        UNKNOWN
    }
    public enum JewelKickerArmPostion //Do we really need this?
    {
        REST,
        ACTION
    }
    public enum Orientation
    {
        LEFT_SIDE,
        RIGHT_SIDE,
        UNKNOWN
    }
    private JewelDetector.JewelOrder jewel_order;
    private SelectedTeam selectedTeam;
    private FireSequence fireSequence;
    private JewelKickerArmPostion jewelKickerArmPostion;
    private Orientation orientation;

    public void setOrientation (Orientation orientation)
    {this.orientation = orientation;}
    public Orientation getOrientation(){return orientation;}
    public void setDetectedOrder (JewelDetector.JewelOrder order){
        jewel_order = order;
    }
    public JewelDetector.JewelOrder getDetectedOrder ()
    {
        return jewel_order;
    }
    public void setSelectedTeam(SelectedTeam team)
    {
        selectedTeam = team;
    }
    public SelectedTeam getSelectedTeam()
    {
        return selectedTeam;
    }
    public void setFireSequence(FireSequence sequence)
    {
        fireSequence= sequence;
    }
    public FireSequence getFireSequence()
    {
        if((getSelectedTeam()==SelectedTeam.BLUE_TEAM) &&(getDetectedOrder() == JewelDetector.JewelOrder.BLUE_RED))
            {
                setFireSequence(FireSequence.FORWARD);
            }
        if((getSelectedTeam()==SelectedTeam.BLUE_TEAM) &&(getDetectedOrder() == JewelDetector.JewelOrder.RED_BLUE))
        {
            setFireSequence(FireSequence.BACKWARD);
        }
        if((getSelectedTeam()==SelectedTeam.RED_TEAM) &&(getDetectedOrder() == JewelDetector.JewelOrder.RED_BLUE))
        {
            setFireSequence(FireSequence.FORWARD);
        }
        if((getSelectedTeam()==SelectedTeam.RED_TEAM) &&(getDetectedOrder() == JewelDetector.JewelOrder.BLUE_RED))
        {
            setFireSequence(FireSequence.BACKWARD);
        }
        return fireSequence;
    }
    public void setJewelKickerArmPostion(JewelKickerArmPostion position)
    {
        jewelKickerArmPostion = position;
    }
    public JewelKickerArmPostion getJewelKickerArmPosition()
    {
        return jewelKickerArmPostion;
    }
    public void Reset()
    {
        opModeConstants = null;
    }
}
