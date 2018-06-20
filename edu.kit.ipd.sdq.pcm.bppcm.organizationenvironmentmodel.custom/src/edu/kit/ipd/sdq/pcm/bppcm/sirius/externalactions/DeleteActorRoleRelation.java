package edu.kit.ipd.sdq.pcm.bppcm.sirius.externalactions;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.Role;

public class DeleteActorRoleRelation implements IExternalJavaAction {

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			DEdge value = (DEdge) entry.getValue();

			EObject source = value.getTarget();
			ActorResource actor = (ActorResource) source;
			
			EdgeTarget targetNode = value.getTargetNode(); 
			Role role = (Role) (((DDiagramElement) targetNode).getTarget());
			
			
			actor.getRoles().remove(role);
			role.getActors().remove(actor);
			
		}

	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}
