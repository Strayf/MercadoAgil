using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

[System.Serializable]
public abstract class BTNode
{
    public delegate NodeStates NodeReturn();
    protected NodeStates currentNodeState;

    public NodeStates nodeState
    {
        get { return currentNodeState; }
    }

    public BTNode() { }
    public abstract NodeStates Evaluate();
}