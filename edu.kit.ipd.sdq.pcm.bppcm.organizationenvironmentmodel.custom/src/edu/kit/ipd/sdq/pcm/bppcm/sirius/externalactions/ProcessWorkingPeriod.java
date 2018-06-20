package edu.kit.ipd.sdq.pcm.bppcm.sirius.externalactions;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.WorkingPeriod;

public class ProcessWorkingPeriod implements IExternalJavaAction {

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		for (EObject eObject : selections) {
			if (eObject instanceof WorkingPeriod) {
				WorkingPeriod wp = (WorkingPeriod) eObject;
				for (Entry<String, Object> entry : parameters.entrySet()) {
					String period = (String) entry.getValue();
					//TODO: validity check
					String[] time = period.split("-");
					if (time.length != 2)
						return;
					for (int i = 0; i < 2; ++i) {
						time[i] = time[i].trim();
						time[i] = time[i].replace(':', '.');
					}
					wp.setPeriodStartTimePoint(Double.parseDouble(time[0]));
					wp.setPeriodEndTimePoint(Double.parseDouble(time[1]));;
				}
				
			}
			
			
		}

	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}
