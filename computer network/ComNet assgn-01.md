## By Nathan Tanaboriboon 6681224

1) Given the frequencies listed below, calculate the corresponding periods.
		a. 24 Hz.
		b. 8 MHz
2) Given the following periods, calculate the corresponding frequencies.
		a. 5 seconds
		b. 12 micro-seconds
3) If the bandwidth of the channel is 5 Kbps. How long does it take to send a frame of 100,000 bitsout of this device?
4) A line has a signal-to-noise ratio of 1000 and a bandwidth of 4000 KHz. What is the maximum data rate supported by this line?
5) A signal with 200 milliwatts power passes through 10 devices, each with an average
noise of 2 microwatts. What is the SNR? What is the SNRdB?

## Answers will be below
1) $Period = \frac{1}{Frequency}$
	1) $\frac{1}{24} = 0.042\space second$
	2) $\frac{1}{8\times 10^{6}} = 0.125\space \mu S$
2) $frequency = \frac{1}{period}$
	1) $\frac{1}{5} = 0.2\space Hz$
	2) $12μS = 12 \times 10^{-6}\space second$
		$\frac{1}{12 \times 10^{-6}} = 83333.33\space Hz$
3) Kpbs means kilo bits per sec, which means, 1 second 1000 bits are sent 5 Kpbs  = 5000 bits are sent per 1 second
$\frac{100,000}{5,000} = 20\space seconds$
4) Noisy channel data rate limit, Shannon capacity$$ bit\space rate\space capacity=Bandwidth\times log_{2}(1+SNR)$$ $bit\space rate = 4000\times 10^3 \times log_{2}(1+1000) = 39.87\space Mbps$
5) 
	1) $SNR = \frac{200\times 10^{-3}}{10\times 2\times 10^{-6}} = 10,000$ 
	2) $SNRdB = 10\times log_{10}(SNR)$ $,\space SNRdB  = 10 \times log_{10}(10,000) = 40dB$

