function [Y, FS, Nbits] = wavread(filename);

% Function wavread
%
% [y,Fs,bits] = wavread('filename.wav') loads a WAVE file specified by the string filename.wav, 
% [returning the sampled data in y. 
%
% [y,Fs,bits] = wavread('filename.wav') returns the sample rate (Fs) in Hertz and the 
% number of bits per sample (bits) used to encode the data in the file.


[Y, FS] = audioread(filename);
if nargout>2,
    INFO = audioinfo(filename);
    Nbits = INFO.BitsPerSample;
end
