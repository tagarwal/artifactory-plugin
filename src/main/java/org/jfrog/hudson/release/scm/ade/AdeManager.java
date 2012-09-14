package org.jfrog.hudson.release.scm.ade;

import hudson.FilePath;
import hudson.model.TaskListener;
import hudson.model.AbstractBuild;
import hudson.remoting.VirtualChannel;

import java.io.File;
import java.io.IOException;

import org.jfrog.hudson.release.scm.AbstractScmManager;
import org.jvnet.hudson.plugins.ade.AdeSCM;

public class AdeManager extends AbstractScmManager<AdeSCM> {

	public AdeManager(AbstractBuild<?, ?> build, TaskListener buildListener) {
		super(build, buildListener);
	}

	public void commitWorkingCopy(String commitMessage) throws IOException,
			InterruptedException {
        build.getWorkspace().act(
        		new AdeCommitWorkingCopyCallable(commitMessage, buildListener));
	}

	public void createTag(String tagUrl, String commitMessage)
			throws IOException, InterruptedException {
        build.getWorkspace().act(
        		new AdeCreateTagCallable(tagUrl, commitMessage, buildListener));
	}

    public String getRemoteUrl() {
		// TODO Auto-generated method stub
		return null;
	}

    private static class AdeCommitWorkingCopyCallable implements FilePath.FileCallable<Object> {
		public AdeCommitWorkingCopyCallable(String commitMessage,
				TaskListener buildListener) {
			// TODO Auto-generated constructor stub
		}

		public Object invoke(File arg0, VirtualChannel arg1)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			return null;
		}
    }
    
    private static class AdeCreateTagCallable implements FilePath.FileCallable<Object> {

		public AdeCreateTagCallable(String tagUrl, String commitMessage,
				TaskListener buildListener) {
			// TODO Auto-generated constructor stub
		}

		public Object invoke(File arg0, VirtualChannel arg1)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			return null;
		}
    }
}
