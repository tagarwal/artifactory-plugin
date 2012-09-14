package org.jfrog.hudson.release.scm.ade;

import hudson.model.BuildListener;
import hudson.model.AbstractBuild;

import java.io.IOException;

import org.jfrog.hudson.release.ReleaseAction;
import org.jfrog.hudson.release.scm.AbstractScmCoordinator;

/**
 * All ADE opertions should be delegated to the AdeManager (and the underlying ADE SCM plugin).
 * The coordinator is just to make any ADE-specific customizations to the release workflow itself
 * 
 * @author slim
 *
 */
public class AdeCoordinator extends AbstractScmCoordinator {
	
	private AdeManager scmManager;

	public AdeCoordinator(AbstractBuild build, BuildListener listener, ReleaseAction releaseAction) {
		super(build, listener);
	}

	public void prepare() throws IOException, InterruptedException {
		scmManager = new AdeManager(build, listener);
	}

    /**
     * Called after a successful release build.  
     * This is where we need to create an ADE "tag" (apply a label to the set of files that have been altered
     * by the release plugin).  
     * 
     * There should be no checked out files in the view at this time.  All checkins should be committed to the repository
     * 
     */
	public void afterSuccessfulReleaseVersionBuild()
			throws InterruptedException, IOException {
		// TODO Auto-generated method stub

	}

    /**
     * Called before changing to next development version.
     * 
     * We may need to make sure that the dev versions are re-checked out here
     */
	public void beforeDevelopmentVersionChange() throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * I expect that this will have to be over-ridden because this is where
	 * the next set of dev files need to be ready to be finalized
	 */
	@Override
	public void afterDevelopmentVersionChange(boolean modified)
			throws IOException, InterruptedException {
		super.afterDevelopmentVersionChange(modified);
		// TODO make sure the finalize file in the view is prepared
	}

    /**
     * Called after the build has completed and the result was finalized.
     */
	public void buildCompleted() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	public String getRemoteUrlForPom() {
		// TODO Auto-generated method stub
		return null;
	}

}
