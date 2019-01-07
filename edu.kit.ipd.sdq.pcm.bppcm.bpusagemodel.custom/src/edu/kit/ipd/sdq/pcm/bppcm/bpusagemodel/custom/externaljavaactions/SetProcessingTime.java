package edu.kit.ipd.sdq.pcm.bppcm.bpusagemodel.custom.externaljavaactions;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.editors.sirius.custom.externaljavaactions.SetRandomVariable;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class SetProcessingTime extends SetRandomVariable {

	@Override
	public RandomVariable getRandomVariable(EObject element) {
		ActorStep d = (ActorStep) element;
		return d.getProcessingTime();
	}

	@Override
	public TypeEnum getExpectedType() {
		return TypeEnum.DOUBLE;
	}





}
