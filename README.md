# IntBIIS-Editor
Sirius-based graphical editors for the three main components of bppcm (https://github.com/PalladioSimulator/Palladio-Addons-IntBIIS):
- bpusagemodel
- organizationenvironmentmodel
- datamodel

## User Guide

### Prerequisites
- Eclipse Modeling Tools (tested with Oxygen)
- Sirius (tested with 5.1.0)
- Palladio Bench core features

### Setup
Since there is still no build pipeline set up for the graphical editors, the following need to be imported into the development and runtime workspaces in the following fashion:

**In the development instance:**
- de.uhd.ifi.se.pcm.bppcm, de.uhd.ifi.se.pcm.bppcm.edit, de.uhd.ifi.se.pcm.bppcm.editor, de.uhd.ifi.se.pcm.bppcm.ui
- edu.kit.ipd.sdq.pcm.bppcm.bpusagemodel.custom, edu.kit.ipd.sdq.pcm.bppcm.organizationenvironmentmodel.custom

**In the runtime instance:**
- edu.kit.ipd.sdq.pcm.bppcm.bpusagemodel, edu.kit.ipd.sdq.pcm.bppcm.organizationenvironmentmodel, edu.kit.ipd.sdq.pcm.bppcm.datamodel

### Usage
- In the runtime instance, create a modeling project and usagemodel, organizationenvironmentmodel and datamodel models
- Select the BPUsageModel, UsageModel, DataModel and OrganizationEnvironmentModel viewpoints
- After opening the representation of the UsageModel, select the BPUsageModel layer to enable the BPUsageModel-specific elements and tools
- Devices and DataObjects created respectively in the OrganizationEnvironmentModel and the DataModel models will be displayed as free-floating in the BPUsageModel diagram (the UsageModel diagram with the BPUsageModel layer enabled) 

## Implementation Details
### BPUsageModel
The BPUsageModel relies on the diagram extension mechanism offered by Sirius to extend the UsageModel diagram editor. To display the BPUsageModel-specific elements inside a ScenarioBehaviour, the UsageScenario mapping is first imported (with openWorkload and closedWorkload set as reused container mappings in the import tab) and the ScenarioBehaviour mapping is then imported inside the UsageScenario Import (with branch, delay, entryLevelSystemCall, loop set as reused container mappings and start, stop set as reused node mappings). The mappings corresponding to the BPUsageModel classes are then created inside the ScenarioBehaviour Import. 

Further, DataObjectNode and DeviceResource mappings are imported respectively from the DataModel and OrganizationEnvironmentModel VSMs into the BPUsageModel VSM. This has the effect of displaying the DataObjects and Devices as free-floating in the BPUsageModel diagram. The displayed elements are the ones specified in OrganizationEnvironmentModel and the DataModel models from the same session (i.e. modeling project) containing the BPUsageModel model. 
