package org.directwebremoting.drapgen;

public class Pair<A, B>
{
    public final A left;

    public final B right;

    public Pair(A left, B right)
    {
        this.left = left;
        this.right = right;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other)
    {
        return other instanceof Pair && equals(left, ((Pair) other).left) && equals(right, ((Pair) other).right);
    }

    private static boolean equals(Object x, Object y)
    {
        return (x == null && y == null) || (x != null && x.equals(y));
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        if (left == null)
        {
            return right.hashCode() + 1;
        }
        else if (right == null)
        {
            return left.hashCode() + 2;
        }
        else
        {
            return left.hashCode() * right.hashCode();
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "[" + left + ":" + right + "]";
    }
}
