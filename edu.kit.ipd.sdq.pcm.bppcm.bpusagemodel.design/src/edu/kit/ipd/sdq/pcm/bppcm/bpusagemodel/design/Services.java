package edu.kit.ipd.sdq.pcm.bppcm.bpusagemodel.design;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;
import org.palladiosimulator.pcm.usagemodel.UsageModel;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.Role;

/**
 * The services class used by VSM.
 */
public class Services {

	public List<Boolean> getPossibleBooleanValues(EObject eObject) {
		List<Boolean> result = new ArrayList<Boolean>();
		result.add(new Boolean(true));
		result.add(new Boolean(false));
		return result;
	}
}
