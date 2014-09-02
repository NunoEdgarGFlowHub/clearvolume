package clearvolume.renderer;

import java.io.Closeable;
import java.nio.ByteBuffer;

import clearvolume.ProjectionAlgorithm;
import clearvolume.controller.RotationControllerInterface;
import clearvolume.transfertf.TransfertFunction;

/**
 * Interface ClearVolumeRenderer
 * 
 * Classes that implement this interface provide the basic functionality of
 * ClearVolume renderer.
 *
 * @author Loic Royer 2014
 *
 */
public interface ClearVolumeRenderer extends
																		DisplayRequest,
																		Closeable
{

	/**
	 * Returns the number of bytes per voxels for the volume data.
	 * 
	 * @return bytes-per-voxel
	 */
	int getBytesPerVoxel();

	/**
	 * Sets the display used by the renderer visible.
	 * 
	 * @param pVisible
	 */
	void setVisible(boolean pVisible);

	/**
	 * Rturns the window name.
	 * 
	 * @return window name.
	 */
	String getWindowName();

	/**
	 * Returns window width.
	 * 
	 * @return window width
	 */
	int getWindowWidth();

	/**
	 * Returns
	 * 
	 * @return window height.
	 */
	int getWindowHeight();

	/**
	 * Returns true if the display is in full-screen mode.
	 * 
	 * @return true if full-screen
	 */
	boolean isFullScreen();

	/**
	 * Toggles fullscreen mode on/off
	 */
	void toggleFullScreen();

	/**
	 * Sets the transfer function used for rendering.
	 * 
	 * @param pTransfertFunction
	 *          transfer function
	 */
	void setTransfertFunction(TransfertFunction pTransfertFunction);

	/**
	 * Sets the transfer function range. Both min and max values should be within
	 * [0,1].
	 * 
	 * @param pMin
	 *          minimum
	 * @param pMax
	 *          maximum
	 */
	void setTransferFunctionRange(double pMin, double pMax);

	/**
	 * Gamma value used for display.
	 * 
	 * @param pGamma
	 */
	void setGamma(double pGamma);

	/**
	 * Resets gamma, brightness, and transfer function range.
	 */
	void resetBrightnessAndGammaAndTransferFunctionRanges();

	/**
	 * Sets the projection algorithm used.
	 * 
	 * @param pProjectionAlgorithm
	 */
	void setProjectionAlgorythm(ProjectionAlgorithm pProjectionAlgorithm);

	/**
	 * Sets the rotation controller used (in addition to the mouse).
	 * 
	 * @param pRotationControllerInterface
	 */
	void setQuaternionController(RotationControllerInterface pRotationControllerInterface);

	/**
	 * 
	 * 
	 * @param pByteBuffer
	 * @param pSizeX
	 * @param pSizeY
	 * @param pSizeZ
	 */
	void setVolumeDataBuffer(	ByteBuffer pByteBuffer,
														long pSizeX,
														long pSizeY,
														long pSizeZ);

	/**
	 * @param pByteBuffer
	 * @param pSizeX
	 * @param pSizeY
	 * @param pSizeZ
	 * @param pVolumeSizeX
	 * @param pVolumeSizeY
	 * @param pVolumeSizeZ
	 */
	void setVolumeDataBuffer(	ByteBuffer pByteBuffer,
														long pSizeX,
														long pSizeY,
														long pSizeZ,
														double pVolumeSizeX,
														double pVolumeSizeY,
														double pVolumeSizeZ);

	/**
	 * Resets rotation and translation parameters.
	 */
	void resetRotationTranslation();

	/**
	 * Translates along x axis by pDX.
	 * 
	 * @param pDX
	 *          amount of translation
	 */
	void addTranslationX(float pDX);

	/**
	 * Translates along y axis by pDY.
	 * 
	 * @param pDY
	 *          amount of translation
	 */
	void addTranslationY(float pDY);

	/**
	 * Translates along z axis by pDZ.
	 * 
	 * @param pDZ
	 *          amount of translation
	 */
	void addTranslationZ(double pDZ);

	/**
	 * Rotates along x axis by pDRX.
	 * 
	 * @param pDRX
	 *          amount of rotation
	 */
	void addRotationX(int pDRX);

	/**
	 * Rotates along y axis by pDRY.
	 * 
	 * @param pDRY
	 *          amount of rotation
	 */
	void addRotationY(int pDRY);

	/**
	 * Returns the translation vector x component.
	 * 
	 * @return x component
	 */
	public float getTranslationX();

	/**
	 * Returns the translation vector x component.
	 * 
	 * @return y component
	 */
	public float getTranslationY();

	/**
	 * Returns the translation vector z component.
	 * 
	 * @return z component
	 */
	public float getTranslationZ();

	/**
	 * Returns the rotation vector x component.
	 * 
	 * @return x component
	 */
	public float getRotationY();

	/**
	 * Returns the rotation vector y component.
	 * 
	 * @return y component
	 */
	public float getRotationX();

	/**
	 * Notifies renderer that display/volume parameters have changed and a display
	 * update is needed.
	 */
	void notifyUpdateOfVolumeRenderingParameters();

	/**
	 * Returns whether the renderer's display is showing.
	 * 
	 * @return true if renderer's display is showing/running.
	 */
	boolean isShowing();

	/**
	 * Interface method implementation
	 * 
	 * @see java.io.Closeable#close()
	 */
	void close();

















}
