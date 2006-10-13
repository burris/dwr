package uk.ltd.getahead.dwrdemo.game;

/**
 * Something someone typed
 */
public class Message
{
    /**
     * @param newtext
     * @param person Who wrote this?
     * @param trusted Is the string trusted
     */
    public Message(String newtext, Person person, boolean trusted)
    {
        text = newtext;

        if (!trusted)
        {
            text = BattleshipUtil.makeSafe(text, 256);
        }

        text = BattleshipUtil.autolink(text);

        this.setPerson(person);
    }

    /**
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * @return the text
     */
    public String getText()
    {
        return text;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person)
    {
        this.person = person;
    }

    /**
     * @return the person
     */
    public Person getPerson()
    {
        return person;
    }

    private long id = System.currentTimeMillis();
    private String text;
    private Person person;
}