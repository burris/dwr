/*
 * Copyright 2005 Joe Walker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object other)
    {
        Pair<A, B> that = (Pair<A, B>) other;
        //noinspection SuspiciousNameCombination
        return other instanceof Pair && equals(this.left, that.left) && equals(this.right, that.right);
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
