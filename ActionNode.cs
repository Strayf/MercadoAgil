using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class ActionNode : BTNode
{
    public delegate NodeStates ActionNodeDelegate();
    private ActionNodeDelegate nodeAction;

    public ActionNode(ActionNodeDelegate action)
    {
        nodeAction = action;
    }
    public override NodeStates Evaluate()
    {
        switch (nodeAction())
        {
            case NodeStates.FAILURE:
                currentNodeState = NodeStates.FAILURE;
                return currentNodeState;
            case NodeStates.SUCESS:
                currentNodeState = NodeStates.SUCESS;
                return currentNodeState;
            case NodeStates.RUNNING:
                currentNodeState = NodeStates.RUNNING;
                return currentNodeState;
            default:
                currentNodeState = NodeStates.FAILURE;
                return currentNodeState;
        }
    }
}