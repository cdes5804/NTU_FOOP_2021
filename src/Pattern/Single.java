package Pattern;

public final class Single extends PatternBase {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean compare() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isValidPattern() {
        return false;
    }
}
