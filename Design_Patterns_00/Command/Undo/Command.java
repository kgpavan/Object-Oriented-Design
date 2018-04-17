package design.design_patterns.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
